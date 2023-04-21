package com.andres.guayabita.domain;

import com.andres.guayabita.app.GuavaApp;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Die {
    private short numberDie;
    private ImageIcon dieFace;
    private final Map<Short,ImageIcon> mapDieFace = new HashMap<>();
    private final ImageIcon dieOne = new ImageIcon(Objects.requireNonNull(GuavaApp.class.getResource("dado1.png")));
    private final ImageIcon dieTwo = new ImageIcon(Objects.requireNonNull(GuavaApp.class.getResource("dado2.png")));
    private final ImageIcon dieThree = new ImageIcon(Objects.requireNonNull(GuavaApp.class.getResource("dado3.png")));
    private final ImageIcon dieFour = new ImageIcon(Objects.requireNonNull(GuavaApp.class.getResource("dado4.png")));
    private final ImageIcon dieFive = new ImageIcon(Objects.requireNonNull(GuavaApp.class.getResource("dado5.png")));
    private final ImageIcon diceSix = new ImageIcon(Objects.requireNonNull(GuavaApp.class.getResource("dado6.png")));

    public Die() {
        this.mapDieFace.put((short) 1,dieOne);
        this.mapDieFace.put((short) 2,dieTwo);
        this.mapDieFace.put((short) 3,dieThree);
        this.mapDieFace.put((short) 4,dieFour);
        this.mapDieFace.put((short) 5,dieFive);
        this.mapDieFace.put((short) 6,diceSix);
    }

    public void rollOfDie(){
        this.numberDie = (short) ((Math.random() * 6) + 1);
        this.dieFace = this.mapDieFace.get(this.numberDie);
    }

    public short getNumberDie() {
        return numberDie;
    }

    public ImageIcon getDieFace() {
        return dieFace;
    }
}
