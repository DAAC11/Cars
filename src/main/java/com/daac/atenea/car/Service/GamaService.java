package com.daac.atenea.car.Service;

import com.daac.atenea.car.Repository.GamaRepository;
import com.daac.atenea.car.entities.Gama;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamaService {
    @Autowired
    private GamaRepository gamaRepository;

    public List<Gama> getAll() {
        return gamaRepository.getAll();
    }

    public Optional<Gama> getGama(int id) {
        return gamaRepository.getGama(id);
    }

    public Gama save(Gama gama) {
        if (gama.getIdGama() == null) {
            return gamaRepository.save(gama);
        } else {
            Optional<Gama> aux = gamaRepository.getGama(gama.getIdGama());
            if (aux.isPresent()) {
                return gama;
            } else {
                return gamaRepository.save(gama);
            }
        }

    }

    public Gama update(Gama gama) {
        if (gama.getIdGama() != null) {
            Optional<Gama> c = gamaRepository.getGama(gama.getIdGama());
            if (c.isPresent()) {
                if (gama.getName() != null) {
                    c.get().setName(gama.getName());
                }
                if (gama.getDescription() != null) {
                    c.get().setDescription(gama.getDescription());
                }
                if (gama.getCars() != null) {
                    c.get().setCars(gama.getCars());
                }
                gamaRepository.save(c.get());
                return c.get();
            } else {
                return gama;
            }
        } else {
            return gama;
        }
    }

    public boolean delete(int id) {
        boolean flag = false;
        Optional<Gama> c = gamaRepository.getGama(id);
        if (c.isPresent()) {
            gamaRepository.delete(c.get());
            flag = true;
        }
        return flag;
    }
}
