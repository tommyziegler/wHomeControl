package whomecontrol.remoteswitch;

import org.springframework.stereotype.Service;

/**
 * Created by tommyziegler on 10/12/13.
 */

@Service
class RemoteSwitchesPi4JService {

    public RemoteSwitchesPi4JService() {
    }

    public void switchRemoteSwitch(RemoteSwitch remoteSwitch) {
        System.out.println("Switch "+remoteSwitch.getName());

    }

}
