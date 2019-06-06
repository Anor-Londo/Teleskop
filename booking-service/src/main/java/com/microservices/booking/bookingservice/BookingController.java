package com.microservices.booking.bookingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BookingController {

    @Autowired
    private BookingRepository repository;

    @Autowired
    private BookingService service;

    /*
    @RequestMapping(value = "booking/add", method = RequestMethod.POST
            , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void add(@RequestBody Booking booking){

        repository.save(booking);
    }
    */

    @PostMapping("booking/add")
    public ResponseEntity<?> createNewBooking(@RequestBody Booking booking, BindingResult result){
        if (result.hasErrors()){
            return new ResponseEntity<String>("Invalid object", HttpStatus.BAD_REQUEST);
        }

        if (!service.CorectTiming(booking))
        {
            return new ResponseEntity<String>("Invalid time", HttpStatus.BAD_REQUEST);
        }
        else
            {
                repository.save(booking);
                return new ResponseEntity<Booking>(booking, HttpStatus.CREATED);
            }
    }

    @RequestMapping(value = "booking", method = RequestMethod.GET)
    public Iterable<Booking> retrieveAllBookings(){
        return repository.findAll();
    }

    @RequestMapping(value = "booking/{id}", method = RequestMethod.GET)
    public Optional<Booking> retrieveBookingById(@PathVariable int id){
        Optional<Booking> booking = repository.findById(id);
        return booking;
    }

    @RequestMapping(value = "booking/delete/{id}", method = RequestMethod.DELETE)
    public void deleteBookingById(@PathVariable int id){
        repository.deleteById(id);
    }


    //----------------------Helpfull_requests_for_gateway--------------------------------//
/*
    @RequestMapping(value = "booking/tableId/{id}", method = RequestMethod.GET)
    public Integer retrieveReservedTable(@PathVariable int id){
        Integer tableId = repository.findTableId(id);
        return tableId;
    }

    @RequestMapping(value = "booking/guestId/{id}", method = RequestMethod.GET)
    public Integer retrieveReservedGuest(@PathVariable int id){
        Integer guestId = repository.findGuestId(id);
        return guestId;
    }
    */
}
