package com.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interfaceService.InPersonaService;
import com.interfaces.InPersona;
import com.model.Persona;

@Service
public class PersonaService implements InPersonaService{

	@Autowired
	private InPersona data;
	
	@Override
	public List<Persona> listar() {
		return (List<Persona>)data.findAll();
	}

	@Override
	public Optional<Persona> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Persona p) {
	    Persona savedPersona = data.save(p);
	    return savedPersona.getId();
	}

	@Override
	public void delete(int id) {
		
	}
	
}
