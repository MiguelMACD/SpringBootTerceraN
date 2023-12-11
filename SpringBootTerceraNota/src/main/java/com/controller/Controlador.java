package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.model.Persona;
import com.interfaceService.InPersonaService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/personas")
public class Controlador {

    @Autowired
    private InPersonaService service;

    @GetMapping("/Listar")
    public String listar(Model model) {
        List<Persona> personas = service.listar();
        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtener(@PathVariable int id) {
        Optional<Persona> persona = service.listarId(id);
        return persona.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public ResponseEntity<Integer> crear(@RequestBody Persona persona) {
        int id = service.save(persona);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Void> actualizar(@PathVariable int id, @RequestBody Persona persona) {
        Optional<Persona> personaExistente = service.listarId(id);
        if (personaExistente.isPresent()) {
            persona.setId(id);
            service.save(persona);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        Optional<Persona> personaExistente = service.listarId(id);
        if (personaExistente.isPresent()) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
