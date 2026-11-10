package com.example.service.controller;

import com.example.service.model.Nombre;
import com.example.service.service.NombreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class NombreController {
    private final NombreService nombreService;
    public NombreController (NombreService nombreService){
        this.nombreService = nombreService;
    }
    @PostMapping
    public ResponseEntity<Nombre> guardar(@RequestBody Nombre nombre) {
        Nombre guardado = nombreService.guardar(nombre.getNombre());
        return ResponseEntity
                .status(200)
                .body(guardado);
    }
    @GetMapping
    public List<Nombre> getAll(){
        return nombreService.getAll();
    }
}
