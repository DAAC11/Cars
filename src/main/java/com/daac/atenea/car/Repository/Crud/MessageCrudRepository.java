package com.daac.atenea.car.Repository.Crud;

import com.daac.atenea.car.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
