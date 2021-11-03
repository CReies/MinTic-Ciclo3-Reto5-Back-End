package com.mintic.ciclo3.repository.crud;

import com.mintic.ciclo3.model.Message;

import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {

}