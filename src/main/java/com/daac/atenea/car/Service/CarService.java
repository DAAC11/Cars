package com.daac.atenea.car.Service;

import com.daac.atenea.car.Repository.CarRepository;
import com.daac.atenea.car.Repository.Crud.CarCrudRepository;
import com.daac.atenea.car.entities.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAll(){
        return carRepository.getAll();
    }

    public Optional<Car> getCar(int id){
        return carRepository.getCar(id);
    }

    public Car save(Car car){
        if (car.getIdCar()==null){
            return carRepository.save(car);
        }else {
            Optional <Car> aux = carRepository.getCar(car.getIdCar());
            if (aux.isPresent()){
                return car;
            }else {
                return carRepository.save(car);
            }
        }
    }

    public Car update(Car car){
        if (car.getIdCar()!=null){
            Optional<Car> c = carRepository.getCar(car.getIdCar());
            if (c.isPresent()){
                if (car.getName()!=null){
                    c.get().setName(car.getName());
                }
                if (car.getBrand() != null){
                    c.get().setBrand(car.getBrand());
                }
                if (car.getYear()!=null){
                    c.get().setYear(car.getYear());
                }
                if (car.getDescription()!=null){
                    c.get().setDescription(car.getDescription());
                }
                if (car.getGama()!=null){
                    c.get().setGama(car.getGama());
                }
                carRepository.save(c.get());
                return c.get();
            }else {
                return car;
            }
        }else {
            return car;
        }
    }
    /*
    public boolean delete(int id){
        boolean flag = false;
        Optional<Car> c = carRepository.getCar(id);
        if(c.isPresent()){
            carRepository.delete(c.get());
            flag = true;
        }
        return flag;
    }*/
    public List<Car> delete(int id){
        boolean flag = false;
        Optional<Car> c = carRepository.getCar(id);
        if(c.isPresent()){
            carRepository.delete(c.get());
            flag = true;
        }
        return getAll();
    }


}
