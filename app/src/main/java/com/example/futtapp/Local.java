package com.example.futtapp;

import android.widget.ImageView;

public class Local {

    private String nombre;
    private int urlFoto;
    private String descripcion;
    private int capacidad;

    public Local(String nombre, int urlFoto, String descripcion, int capacidad){
        this.nombre = nombre;
        this.urlFoto=urlFoto;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(int urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
