package whomecontrol.remoteswitch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by tommyziegler on 09/12/13.
 */

@RestController
@RequestMapping("/switches" )
class RemoteSwitchesController {

    @Autowired
    RemoteSwitchesService remoteSwitchesService;

    @RequestMapping
    Collection<RemoteSwitch> findAll() {
        return remoteSwitchesService.findAll();
    }

    @RequestMapping(value = "/{id}")
    RemoteSwitch findById(@PathVariable Long id) {
        return remoteSwitchesService.findById(id);
    }

    @RequestMapping(value = "/switch", method = RequestMethod.PUT)
    void switchAll(@RequestBody RemoteSwitch dto) {
        remoteSwitchesService.switchAll(dto.getStatus());
    }

    @RequestMapping(value = "/{id}/switch", method = RequestMethod.PUT)
    void switchById(@PathVariable Long id, @RequestBody RemoteSwitch dto) {
        remoteSwitchesService.switchById(id, dto.getStatus());
    }

    @RequestMapping(value = "/switch", method = RequestMethod.POST)
    void create(@RequestBody RemoteSwitch dto) {
        remoteSwitchesService.create(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    void update(@PathVariable Long id, @RequestBody RemoteSwitch dto) {
        remoteSwitchesService.update(id, dto);
    }
}
