package com.sipf.sipfapi.repository;

import com.sipf.sipfapi.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByActiveTrue();
}
