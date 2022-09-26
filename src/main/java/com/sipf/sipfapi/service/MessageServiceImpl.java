package com.sipf.sipfapi.service;

import com.sipf.sipfapi.model.Message;
import com.sipf.sipfapi.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public Message create(Message message) {
        message.setCreatedAt(new Date());
        return messageRepository.save(message);
    }

    @Override
    public List<Message> read() {
        return messageRepository.findAll();
    }

    @Override
    public Optional<Message> readOne(Long id) {
        return messageRepository.findById(id);
    }

    @Override
    public List<Message> readActive() {
        return messageRepository.findByActiveTrue();
    }

    @Override
    public Optional<Message> update(Long id, Message message) {
        return Optional.ofNullable(messageRepository.findById(id).map(m -> {
            m.setContent(message.getContent());
            m.setLastModified(new Date());
            m.setActive(message.isActive());
            return messageRepository.save(m);
        }).orElseThrow(() -> new RuntimeException("Message non trouvé! ")));
    }

    @Override
    public String delete(Long id) {
        messageRepository.deleteById(id);
        return "Message supprimé.";
    }
}

