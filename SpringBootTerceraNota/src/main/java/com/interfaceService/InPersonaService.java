package com.interfaceService;

import java.util.List;
import java.util.Optional;

import com.model.Persona;

public interface InPersonaService {

	public List<Persona>listar();
	public Optional<Persona>listarId(int id);
	public int save(Persona p);
	public void delete(int id);
}
