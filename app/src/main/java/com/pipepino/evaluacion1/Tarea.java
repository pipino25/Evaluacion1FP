package com.pipepino.evaluacion1;

public class Tarea {
    private String nombre;
    private String fecha;
    private String hora;


    public Tarea(String nombre, String fecha, String hora) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;

    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }
}
