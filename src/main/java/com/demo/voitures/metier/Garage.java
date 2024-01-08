package com.demo.voitures.metier;

import java.util.ArrayList;

public class Garage {

    private ArrayList<Voiture> voitures = new ArrayList<>();

    public void addVoiture(Voiture voiture){
        voitures.add(voiture);
    }

    public ArrayList<Voiture> getVoitures() {
        return voitures;
    }
}
