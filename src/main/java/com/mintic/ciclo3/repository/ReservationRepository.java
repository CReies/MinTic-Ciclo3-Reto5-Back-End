package com.mintic.ciclo3.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.mintic.ciclo3.model.Client;
import com.mintic.ciclo3.model.Reservation;
import com.mintic.ciclo3.model.auxiliar.CountClient;
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

  public Reservation edit(Reservation r) {
    return reservationCrudRepository.save(r);
  }

  public void delete(int id) {
    reservationCrudRepository.deleteById(id);
  }

  public List<Reservation> getReservationPeriod(Date date1, Date date2) {
    return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(date1, date2);
  }

  public List<Reservation> getReservationStatus(String status) {
    return reservationCrudRepository.findAllByStatus(status);
  }

  public List<CountClient> getReservationClient() {
    List<CountClient> res = new ArrayList<>();
    List<Object[]> report = reservationCrudRepository.countTotalReservationsByClient();
    for (int i = 0; i < report.size(); i++) {
      res.add(new CountClient((Long) report.get(i)[1], (Client) report.get(i)[0]));
    }
    return res;
  }
}
