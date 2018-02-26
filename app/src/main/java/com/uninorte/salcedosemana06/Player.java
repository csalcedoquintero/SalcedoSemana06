package com.uninorte.salcedosemana06;

import java.io.Serializable;

/**
 * Created by Visitante on 26/02/2018.
 */

public class Player implements Serializable {
    String name, lastname, position;
    boolean selected;
    int age;

    public Player(String name, String lastname, String position, boolean selected, int age){
        this.name = name;
        this.lastname = lastname;
        this.position = position;
        this.selected = selected;
        this.age = age;
    }
}
