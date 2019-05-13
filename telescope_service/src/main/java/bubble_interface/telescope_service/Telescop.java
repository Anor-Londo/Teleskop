package bubble_interface.telescope_service;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "telescop")
public class Telescop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "parameters")
    private String parameters;

    @Column(name = "timeBegin")
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timeBegin;

    @Column(name = "timeEnd")
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timeEnd;

    @Column(name = "coords")
    private String coords;

    @Column(name = "reserved")
    private boolean reserved;

    @Column(name = "telescop_number")
    private int telescopNumber;

    public Telescop() {
    }

    public Telescop(String parameters, LocalDateTime timeBegin, LocalDateTime timeEnd, String coords, boolean reserved, int telescopNumber) {
        this.parameters = parameters;
        this.timeEnd = timeEnd;
        this.timeBegin = timeBegin;
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

    public LocalDateTime getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(LocalDateTime timeBegin) {
        this.timeBegin = timeBegin;
    }

    public LocalDateTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalDateTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public String toString() {
        return "Telescop{" +
                "id=" + id +
                ", parameters='" + parameters + '\'' +
                ", timeEnd=" + timeEnd +
                ", timeBegin=" + timeBegin +
                ", coords='" + coords + '\'' +
                ", reserved=" + reserved +
                ", telescopNumber=" + telescopNumber +
                '}';
    }
}
