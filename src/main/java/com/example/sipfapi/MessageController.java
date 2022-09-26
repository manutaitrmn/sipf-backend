package com.example.sipfapi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MessageController {

    @GetMapping(path = "/messages")
    public String messages() {
        return "Messages";
    }

    @GetMapping(path = "/messages/{id}")
    public String message(@PathVariable int id) {
        return String.valueOf(id) ;
    }
}
