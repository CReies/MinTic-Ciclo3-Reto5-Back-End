package com.mintic.ciclo3.repository;

import java.util.List;
import java.util.Optional;

import com.mintic.ciclo3.model.Boat;
import com.mintic.ciclo3.repository.crud.BoatCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoatRepository {
  @Autowired
  private BoatCrudRepository boatCrudRepository;

  public List<Boat> getAll() {
    return (List<Boat>) boatCrudRepository.findAll();
  }

  public Optional<Boat> getBoat(int id) {
    return boatCrudRepository.findById(id);
  };

  public Boat save(Boat b) {
    return boatCrudRepository.save(b);
  }
}
