package com.demo.singleton;

import java.util.ArrayList;

public class Annuaire {

    private static Annuaire singleton;

    private ArrayList<Personne> personnes = new ArrayList<>();

    private Annuaire(){
        personnes.add(new Personne("JC", "Dominguez"));
        personnes.add(new Personne("Michel", "Dupont"));

    }

    public static Annuaire getAnnuaire(){
        if(singleton == null){
            singleton = new Annuaire();
        }

        return singleton;
    }

    public ArrayList<Personne> getPersonnes() {
        return personnes;
    }
}
