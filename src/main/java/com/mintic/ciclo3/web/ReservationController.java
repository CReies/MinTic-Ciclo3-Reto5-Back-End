package com.mintic.ciclo3.web;

import java.util.List;
import java.util.Optional;

import com.mintic.ciclo3.model.Reservation;
import com.mintic.ciclo3.model.auxiliar.CountClient;
import com.mintic.ciclo3.model.auxiliar.ReportStatus;
import com.mintic.ciclo3.service.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
    RequestMethod.DELETE })
public class ReservationController {

  @Autowired
  private ReservationService reservationService;

  @GetMapping("/all")
  public List<Reservation> getReservations() {
    return reservationService.getAll();
  }

  @GetMapping("/{id}")
  public Optional<Reservation> getReservation(@PathVariable("id") int id) {
    return reservationService.getReservation(id);
  }

  @GetMapping("/report-dates/{date1}/{date2}")
  public List<Reservation> getReservationPeriod(@PathVariable("date1") String d1, @PathVariable("date2") String d2) {
    return reservationService.getReservationPeriod(d1, d2);
  }

  @GetMapping("/report-status")
  public ReportStatus getReservationStatus() {
    return reservationService.getReservationStatus();
  }

  @GetMapping("/report-clients")
  public List<CountClient> getReservationClient() {
    return reservationService.getReservationClient();
  }

  @PostMapping("/save")
  @ResponseStatus(HttpStatus.CREATED)
  public Reservation save(@RequestBody Reservation r) {
    return reservationService.save(r);
  }

  @PutMapping("/update")
  @ResponseStatus(HttpStatus.CREATED)
  public Reservation edit(@RequestBody Reservation r) {
    return reservationService.edit(r);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") int id) {
    reservationService.delete(id);
  }
}
