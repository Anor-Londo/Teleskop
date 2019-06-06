package com.microservices.booking.bookingservice;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@FeignClient(name = "user-service", url = "localhost:8004")
public interface UserServiceProxy {

    @RequestMapping(value = "/api/users/user/{id}", method = RequestMethod.GET)
    public Optional<User> findGuestById(@PathVariable("id") Long id);
}
