package com.daac.atenea.car.Repository.Crud;

import com.daac.atenea.car.entities.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarCrudRepository extends CrudRepository<Car,Integer> {
}
