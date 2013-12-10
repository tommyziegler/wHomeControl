package whomecontrol.remoteswitch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.Remote;
import java.util.List;

@Service
class RemoteSwitchesService {

    RemoteSwitchesDao remoteSwitchesDao = null;
    RemoteSwitchesPi4JService remoteSwitchesPi4JService = null;

    @Autowired
    public RemoteSwitchesService(RemoteSwitchesDao remoteSwitchesDao, RemoteSwitchesPi4JService remoteSwitchesPi4JService) {
        this.remoteSwitchesDao = remoteSwitchesDao;
        this.remoteSwitchesPi4JService = remoteSwitchesPi4JService;
    }

    public RemoteSwitch create(RemoteSwitch dto) {
        return remoteSwitchesDao.save(dto);
    }

    public RemoteSwitch update(Long id, RemoteSwitch dto) {
        RemoteSwitch remoteSwitch = remoteSwitchesDao.findOne(id);
        if (remoteSwitch != null) {

            // Properties which should be copied
            remoteSwitch.setName(dto.getName());

            remoteSwitch = remoteSwitchesDao.save(remoteSwitch);
        }

        return remoteSwitch;
    }

    public List<RemoteSwitch> findAll() {
        return remoteSwitchesDao.findAll();
    }

    public RemoteSwitch findById(Long id) {
        return remoteSwitchesDao.findOne(id);
    }

    public void switchAll(Integer status) {
        for(RemoteSwitch remoteSwitch : this.findAll()) {
            switchRemoteSwitchIfNeededAndSaveChanges(remoteSwitch, status);
        }
    }

    public void switchById(Long id, Integer status) {
        RemoteSwitch entity = remoteSwitchesDao.findOne(id);
        if (entity != null) {
            switchRemoteSwitchIfNeededAndSaveChanges(entity, status);
        }
    }

    private void switchRemoteSwitchIfNeededAndSaveChanges(RemoteSwitch remoteSwitch, Integer status) {
        if(remoteSwitch.getStatus().intValue() != status.intValue())  {
            remoteSwitch.setStatus(status);
            remoteSwitchesPi4JService.switchRemoteSwitch(remoteSwitch);
            remoteSwitchesDao.save(remoteSwitch);
        }
    }
}
