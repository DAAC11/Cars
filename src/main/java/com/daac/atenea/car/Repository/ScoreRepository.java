package com.daac.atenea.car.Repository;

import com.daac.atenea.car.Repository.Crud.ScoreCrudRepository;
import com.daac.atenea.car.entities.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    public Optional<Score> getScore(int id){
        return scoreCrudRepository.findById(id);
    }

    public Score save(Score score){
        return scoreCrudRepository.save(score);
    }

    public void delete(Score score){
        scoreCrudRepository.delete(score);
    }
}
