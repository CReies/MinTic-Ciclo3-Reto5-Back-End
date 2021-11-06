package com.mintic.ciclo3.service;

import java.util.List;
import java.util.Optional;

import com.mintic.ciclo3.model.Boat;
import com.mintic.ciclo3.repository.BoatRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoatService {
  @Autowired
  private BoatRepository boatRepository;

  public List<Boat> getAll() {
    return boatRepository.getAll();
  }

  public Optional<Boat> getBoat(int id) {
    return boatRepository.getBoat(id);
  }

  public Boat save(Boat b) {
    if (b.getId() == null) {
      return boatRepository.save(b);
    } else {
      Optional<Boat> baux = boatRepository.getBoat(b.getId());
      if (baux.isEmpty()) {
        return boatRepository.save(b);
      } else {
        return b;
      }
    }
  }

  public Boat edit(Boat b) {
    b.setCategory(boatRepository.getBoat(b.getId()).get().getCategory());
    return boatRepository.edit(b);
  }

  public void delete(int id) {
    boatRepository.delete(id);
  }
}
