package com.daac.atenea.car.Repository.Crud;

import com.daac.atenea.car.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
}
