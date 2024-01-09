package com.demo.vip.metier;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class AnnuairePersonnes {

    private ArrayList<Personne> personnes = new ArrayList<>();

    public AnnuairePersonnes() {

        personnes.add(new Personne("JC", "Dominguez", true));
        personnes.add(new Personne("Michel", "Dupont", true));
        personnes.add(new Personne("Marie", "Dufour", false));
        personnes.add(new Personne("Steeve", "Brown", false));
    }

    public ArrayList<Personne> getPersonnesVip() {
        ArrayList<Personne> vips = new ArrayList<>();
        for(Personne p : personnes){
            if(p.isVip())
                vips.add(p);
        }
        return vips;
    }
    public ArrayList<Personne> getPersonnesNonVip() {
        ArrayList<Personne> nonvips = personnes.stream().filter(
                p -> !p.isVip()
        ).collect(Collectors.toCollection(ArrayList::new));

        return nonvips;
    }

    public void addPersonne(Personne personne){
        personnes.add(personne);
    }
}
