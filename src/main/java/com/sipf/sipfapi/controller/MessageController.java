package com.sipf.sipfapi.controller;

import com.sipf.sipfapi.model.Message;
import com.sipf.sipfapi.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/message")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class MessageController {
    private final MessageService messageService;

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Message create(@RequestBody Message message) {
        return messageService.create(message);
    }

    @GetMapping("/read/active")
    public List<Message> readActive() {
        return messageService.readActive();
    }

    @GetMapping("/read/{id}")
    public Optional<Message> readById(@PathVariable Long id) {
        return messageService.readOne(id);
    }

    @GetMapping("/read")
    public List<Message> read() {
        return messageService.read();
    }

    @PutMapping("/update/{id}")
    public Optional<Message> update(@PathVariable Long id, @RequestBody Message message) {
        return messageService.update(id, message);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return messageService.delete(id);
    }
}
