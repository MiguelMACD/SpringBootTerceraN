package com.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Persona;

@Repository
public interface InPersona extends CrudRepository<Persona, Integer>{

}
