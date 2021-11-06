package com.mintic.ciclo3.service;

import java.util.List;
import java.util.Optional;

import com.mintic.ciclo3.model.Client;
import com.mintic.ciclo3.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
  @Autowired
  private ClientRepository clientRepository;

  public List<Client> getAll() {
    return clientRepository.getAll();
  }

  public Optional<Client> getClient(int id) {
    return clientRepository.getClient(id);
  }

  public Client save(Client c) {
    if (c.getIdClient() == null) {
      return clientRepository.save(c);
    } else {
      Optional<Client> caux = clientRepository.getClient(c.getIdClient());
      if (caux.isEmpty()) {
        return clientRepository.save(c);
      } else {
        return c;
      }
    }
  }

  public Client edit(Client c) {
    return clientRepository.edit(c);
  }

  public void delete(int id) {
    clientRepository.delete(id);
  }
}
