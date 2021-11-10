package com.mintic.ciclo3.repository.crud;

import java.util.Date;
import java.util.List;

import com.mintic.ciclo3.model.Reservation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
  public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date date1, Date date2);

  public List<Reservation> findAllByStatus(String status);

  @Query("select c.client, count(c.client) from Reservation as c group by c.client order by count(c.client) desc")
  public List<Object[]> countTotalReservationsByClient();
}