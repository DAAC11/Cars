package com.daac.atenea.car.Repository;

import com.daac.atenea.car.Repository.Crud.ReservationCrudRepository;
import com.daac.atenea.car.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    
    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }


    //Reto 5
    public List<Reservation> getReservationPeriod(Date a, Date b){
        return
                reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a,b);
    }
}
