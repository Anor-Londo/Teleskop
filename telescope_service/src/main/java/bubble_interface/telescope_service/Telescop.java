package bubble_interface.telescope_service;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Telescop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "parameters")
    private String parameters;

    @Column(name = "time")
    private Date time;

    @Column(name = "coords")
    private String coords;

    @Column(name = "reserved")
    private boolean reserved;

    @Column(name = "telescop_number")
    private int telescopNumber;

    public Telescop() {
    }

    public Telescop(String parameters, Date time, String coords, boolean reserved, int telescopNumber) {
        this.parameters = parameters;
        this.time = time;
        this.coords = coords;
        this.reserved = reserved;
        this.telescopNumber = telescopNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getCoords() {
        return coords;
    }

    public void setCoords(String coords) {
        this.coords = coords;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public int getTelescopNumber() {
        return telescopNumber;
    }

    public void setTelescopNumber(int telescopNumber) {
        this.telescopNumber = telescopNumber;
    }

    @Override
    public String toString() {
        return "Telescop{" +
                "id=" + id +
                ", parameters='" + parameters + '\'' +
                ", time=" + time +
                ", coords='" + coords + '\'' +
                ", reserved=" + reserved +
                ", telescopNumber=" + telescopNumber +
                '}';
    }
}
