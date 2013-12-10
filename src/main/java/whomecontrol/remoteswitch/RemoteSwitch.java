package whomecontrol.remoteswitch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by tommyziegler on 09/12/13.
 */

@Entity
class RemoteSwitch {

    RemoteSwitch() {}

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "switch_name")
    private String name;

    @Column(name = "switch_status")
    private Integer status = 0;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getStatus() { return status; }

}
