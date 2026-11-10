package com.example.service.model;


public class Nombre {
    private String nombres;
    public Nombre(){};

    public Nombre(String nombres) {
        this.nombres = nombres;
    }

    public String getNombre() {
        return nombres;
    }

    public void setNombre(String nombres) {
        this.nombres = nombres;
    }
}

