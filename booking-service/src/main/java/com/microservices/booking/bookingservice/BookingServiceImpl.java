package com.microservices.booking.bookingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private BookingService service;
    private BookingRepository repository;

    public BookingService getService() {
        return service;
    }

    @Autowired
    public void setService(BookingService service) {
        this.service = service;
    }

    public BookingRepository getRepository() {
        return repository;
    }

    @Autowired
    public void setRepository(BookingRepository repository) {
        this.repository = repository;
    }

    @Autowired
    private TelescopServiceProxy telescopServiceProxy;

    @Override
    public boolean CorectTiming(Booking booking)
    {
        Telescop telescop = telescopServiceProxy.retrieveTelescopById(booking.getTelescopId());

        if ((booking.getTimeBegin().isAfter(telescop.getTimeBegin()))
                && (booking.getTimeEnd().isBefore(telescop.getTimeEnd())))
            return true;
        return false;
    }
}
