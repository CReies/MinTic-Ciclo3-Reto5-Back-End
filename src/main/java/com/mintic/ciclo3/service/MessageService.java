package com.mintic.ciclo3.service;

import java.util.List;
import java.util.Optional;

import com.mintic.ciclo3.model.Message;
import com.mintic.ciclo3.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
  @Autowired
  private MessageRepository messageRepository;

  public List<Message> getAll() {
    return messageRepository.getAll();
  }

  public Optional<Message> getMessage(int id) {
    return messageRepository.getMessage(id);
  }

  public Message save(Message m) {
    if (m.getIdMessage() == null) {
      return messageRepository.save(m);
    } else {
      Optional<Message> maux = messageRepository.getMessage(m.getIdMessage());
      if (maux.isEmpty()) {
        return messageRepository.save(m);
      } else {
        return m;
      }
    }
  }

  public Message edit(Message m) {
    return messageRepository.edit(m);
  }

  public void delete(int id) {
    messageRepository.delete(id);
  }
}
