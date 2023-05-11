package com.daac.atenea.car.Repository.Crud;

import com.daac.atenea.car.entities.Reservation;

import org.springframework.data.repository.CrudRepository;


import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {

    //Reto 5
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);


}
