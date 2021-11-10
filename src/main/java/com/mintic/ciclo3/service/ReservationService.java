package com.mintic.ciclo3.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.mintic.ciclo3.model.Reservation;
import com.mintic.ciclo3.model.auxiliar.CountClient;
import com.mintic.ciclo3.model.auxiliar.ReportStatus;
import com.mintic.ciclo3.repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
  @Autowired
  private ReservationRepository reservationRepository;

  public List<Reservation> getAll() {
    return reservationRepository.getAll();
  }

  public Optional<Reservation> getReservation(int id) {
    return reservationRepository.getReservation(id);
  }

  public Reservation save(Reservation r) {
    if (r.getIdReservation() == null) {
      return reservationRepository.save(r);
    } else {
      Optional<Reservation> raux = reservationRepository.getReservation(r.getIdReservation());
      if (raux.isEmpty()) {
        return reservationRepository.save(r);
      } else {
        return r;
      }
    }
  }

  public Reservation edit(Reservation r) {
    return reservationRepository.edit(r);
  }

  public void delete(int id) {
    reservationRepository.delete(id);
  }

  public List<Reservation> getReservationPeriod(String date1, String date2) {
    SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
    Date d1 = new Date();
    Date d2 = new Date();
    try {
      d1 = parser.parse(date1);
      d2 = parser.parse(date2);
    } catch (Exception e) {
      e.printStackTrace();
    }

    if (d1.before(d2)) {
      return reservationRepository.getReservationPeriod(d1, d2);
    } else {
      return new ArrayList<>();
    }

  }

  public ReportStatus getReservationStatus() {
    List<Reservation> completed = reservationRepository.getReservationStatus("completed");
    List<Reservation> cancelled = reservationRepository.getReservationStatus("cancelled");

    ReportStatus rStatus = new ReportStatus(completed.size(), cancelled.size());
    return rStatus;
  }

  public List<CountClient> getReservationClient() {
    return reservationRepository.getReservationClient();
  }
}
