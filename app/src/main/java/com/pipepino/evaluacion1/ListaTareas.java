package com.pipepino.evaluacion1;

import java.util.ArrayList;
//listado para el backend, administrando un arraylist en una instancia unica tipo singleton
public class ListaTareas {
    private static ListaTareas instance;
    private ArrayList<Tarea> listaTareas;

    private ListaTareas(){
        listaTareas = new ArrayList<>();
    }
    public static synchronized ListaTareas getInstance() {
        if (instance == null) {
            instance = new ListaTareas();
        }
        return instance;
    }

    public ArrayList<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void addTarea(Tarea tarea) {
        listaTareas.add(tarea);
    }
}
