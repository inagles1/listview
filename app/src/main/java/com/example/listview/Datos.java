package com.example.listview;

import java.util.ArrayList;

public class Datos {

    private static ArrayList<Operacion> datos = new ArrayList();


    public static void guardar(Operacion d){ datos.add(d); }

    public static ArrayList<Operacion> obtener(){
        return datos;
    }



}
