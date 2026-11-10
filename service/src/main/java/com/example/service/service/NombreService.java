package com.example.service.service;

import com.example.service.model.Nombre;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NombreService {
    private final List<Nombre> nombres = new ArrayList<>();
    public Nombre guardar(String nombre){
        Nombre newNombre = new Nombre(nombre);
        nombres.add(newNombre);
        return newNombre;
    }
    public List<Nombre> getAll(){
        return nombres;
    }
}
