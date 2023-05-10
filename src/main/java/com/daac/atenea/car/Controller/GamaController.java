package com.daac.atenea.car.Controller;

import com.daac.atenea.car.Service.GamaService;
import com.daac.atenea.car.entities.Gama;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Gama")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class GamaController {

    @Autowired
    private GamaService gamaService;

    @GetMapping("/all")
    public List<Gama> getGamas(){
        return gamaService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Gama> getGama(@PathVariable("id")int id){
        return gamaService.getGama(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama save(@RequestBody Gama gama){
        return gamaService.save(gama);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama update(@RequestBody Gama gama){
        return gamaService.update(gama);
    }

    /*
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id")int id){
        return gamaService.delete(id);
    }*/

    //Reto 4
    @DeleteMapping("/{id}")
    public List<Gama> delete(@PathVariable("id")int id){
        gamaService.delete(id);
        return getGamas();
    }
}
