package com.microservices.booking.bookingservice;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "telescop-service", url = "localhost:8000")
public interface TelescopServiceProxy {

    @RequestMapping(value = "telescop/{id}", method = RequestMethod.GET)
    public Telescop retrieveTelescopById(@PathVariable("id") Integer id);

    @RequestMapping(value = "telescop/timeBegin", method = RequestMethod.GET)
    public List<Telescop> retrieveTelescopsByBeginDate(@RequestParam(value = "timeBegin")
                                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                               LocalDateTime time);

    @RequestMapping(value = "telescop/timeEnd", method = RequestMethod.GET)
    public List<Telescop> retrieveTelescopsByEndDate(@RequestParam(value = "timeEnd")
                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                                 LocalDateTime time);
}
