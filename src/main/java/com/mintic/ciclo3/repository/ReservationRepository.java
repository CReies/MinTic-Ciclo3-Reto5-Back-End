package com.mintic.ciclo3.repository;

import java.util.List;
import java.util.Optional;

import com.mintic.ciclo3.model.Reservation;
import com.mintic.ciclo3.repository.crud.ReservationCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {
  @Autowired
  private ReservationCrudRepository reservationCrudRepository;

  public List<Reservation> getAll() {
    return (List<Reservation>) reservationCrudRepository.findAll();
  }

  public Optional<Reservation> getReservation(int id) {
    return reservationCrudRepository.findById(id);
  };

  public Reservation save(Reservation r) {
    return reservationCrudRepository.save(r);
  }
}
