package com.daac.atenea.car.Controller;


import com.daac.atenea.car.Service.CarService;
import com.daac.atenea.car.entities.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Car")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/all")
    public List<Car> getCars(){
        return carService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Car> getCar(@PathVariable("id")int id){
        return carService.getCar(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Car save(@RequestBody Car car){
        return carService.save(car);
    }

    @PutMapping("/update")
    public Car update(@RequestBody Car car){
        return carService.update(car);
    }

    /*
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return carService.delete(id);
    }*/
    @DeleteMapping("/{id}")
    public List<Car> delete(@PathVariable("id") int id){
        carService.delete(id);
        return getCars();
    }
}
