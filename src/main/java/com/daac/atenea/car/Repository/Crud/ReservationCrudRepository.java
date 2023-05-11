package com.daac.atenea.car.Repository.Crud;

import com.daac.atenea.car.entities.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {

    //Reto 5

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    //@Query(value = "SELECT status, COUNT(*) as count FROM reservation WHERE status IN ('completed', 'canceled') GROUP BY status", nativeQuery = true)
    @Query(value = "USE cars; SELECT status FROM reservation;", nativeQuery = true)
    public List<Reservation> statusCount();
}
