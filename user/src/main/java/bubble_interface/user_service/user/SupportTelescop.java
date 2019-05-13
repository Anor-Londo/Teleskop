package bubble_interface.user_service.user;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;

@Entity
@Table(name = "support")
public class SupportTelescop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "u_id")
    private Long u_id;

    @Column(name = "t_id")
    private Long t_id;

    public SupportTelescop() {
    }

    public SupportTelescop(Long u_id, Long t_id) {
        this.u_id = u_id;
        this.t_id = t_id;
    }

    public Long getU_id() {
        return u_id;
    }

    public void setU_id(Long u_id) {
        this.u_id = u_id;
    }

    public Long getT_id() {
        return t_id;
    }

    public void setT_id(Long t_id) {
        this.t_id = t_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SupportTelescop{" +
                "id=" + id +
                ", u_id=" + u_id +
                ", t_id=" + t_id +
                '}';
    }
}
