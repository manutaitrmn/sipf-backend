package com.sipf.sipfapi.service;
import com.sipf.sipfapi.model.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {

    Message create(Message message);

    List<Message> read();

    Optional<Message> readOne(Long id);

    List<Message> readActive();

    Optional<Message> update(Long id, Message message);

    String delete(Long id);

}
