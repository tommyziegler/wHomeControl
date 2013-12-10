package whomecontrol.remoteswitch;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tommyziegler on 09/12/13.
 */
interface RemoteSwitchesDao extends JpaRepository<RemoteSwitch, Long> {
}
