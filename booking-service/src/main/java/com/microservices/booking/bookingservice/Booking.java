package com.microservices.booking.bookingservice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "telescop_id")
    private int telescopId;

    @Column(name = "user_id")
    private int guestId;

    @Column(name = "user_name")
    private String guestName;

    @Column(name = "telescop_number")
    private int telescopNumber;

    @Column(name = "timeBegin")
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timeBegin;

    @Column(name = "timeEnd")
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timeEnd;

    @Column(name = "coords")
    private String coords;

    public Booking(){

    }

    public Booking(int telescopId, int guestId, String guestName,
                   int telescopNumber, LocalDateTime timeBegin, LocalDateTime timeEnd, String coords) {
        this.telescopId = telescopId;
        this.guestId = guestId;
        this.guestName = guestName;
        this.telescopNumber = telescopNumber;
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
        this.coords = coords;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTelescopId() {
        return telescopId;
    }

    public void setTelescopId(int telescopId) {
        this.telescopId = telescopId;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
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

    public String getCoords() {
        return coords;
    }

    public void setCoords(String coords) {
        this.coords = coords;
    }
}
