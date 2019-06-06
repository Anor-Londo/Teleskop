package com.microservices.booking.bookingservice;

import java.time.LocalDateTime;

public class Telescop {

    private Integer id;
    private String parameters;
    private LocalDateTime timeBegin;
    private LocalDateTime timeEnd;
    private String coords;
    private boolean reserved;
    private int telescopNumber;

    public Telescop() {
    }

    public Telescop(String parameters, LocalDateTime timeBegin, LocalDateTime timeEnd,
                    String coords, boolean reserved, int telescopNumber) {
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
}
