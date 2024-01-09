package com.demo.bibliotheque.metier;

import java.util.ArrayList;

public class Bibliotheque {

    private int compteurIdentifiantLivre = 0;

    private ArrayList<Livre> livres = new ArrayList<>();

    public ArrayList<Livre> getLivres() {
        return livres;
    }

    public void addLivre(Livre livre){
        livre.setId(compteurIdentifiantLivre++);
        livres.add(livre);
    }

    public void updateLivre(Livre livre){

        for(Livre l : livres){
            if(l.getId().equals(livre.getId())){
                l.setTitre(livre.getTitre());
                l.setAuteur(livre.getAuteur());
                l.setIsbn(livre.getIsbn());
                break;
            }
        }
    }

    public ArrayList<Livre> search(String searchKeyword){
        ArrayList<Livre> livresRecherche = new ArrayList<>();

        for(Livre l : livres) {
            if (l.getTitre().contains(searchKeyword) || l.getAuteur().contains(searchKeyword)) {
                livresRecherche.add(l);
            }
        }
        return livresRecherche;
    }


    /** SINGLETON **/
    private static Bibliotheque instance;

    private Bibliotheque(){
        livres.add(new Livre("1984", "George Orwell", "978-0-452-28423-4"));
        livres.add(new Livre("Pride and Prejudice", "Jane Austen", "978-0-19-953556-9"));
        livres.add(new Livre("The Catcher in the Rye", "J.D. Salinger", "978-0-316-76948-0"));
        livres.add(new Livre("The Hobbit", "J.R.R. Tolkien", "978-0-618-00221-4"));
        livres.add(new Livre("One Hundred Years of Solitude", "Gabriel Garcia Marquez", "978-0-06-112008-4"));
        livres.add(new Livre("Brave New World", "Aldous Huxley", "978-0-06-112008-4"));
        livres.add(new Livre("The Lord of the Rings", "J.R.R. Tolkien", "978-0-618-00221-4"));
        livres.add(new Livre("The Chronicles of Narnia", "C.S. Lewis", "978-0-06-112008-4"));
        livres.add(new Livre("The Shining", "Stephen King", "978-0-385-12167-5"));
        livres.add(new Livre("The Great Gatsby", "F. Scott Fitzgerald", "978-3-16-148410-0"));
        livres.add(new Livre("The Hunger Games", "Suzanne Collins", "978-0-439-02348-1"));
        livres.add(new Livre("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "978-0-439-02348-1"));
        livres.add(new Livre("The Da Vinci Code", "Dan Brown", "978-0-385-50420-1"));
        livres.add(new Livre("The Alchemist", "Paulo Coelho", "978-0-06-112008-4"));
        livres.add(new Livre("The Girl with the Dragon Tattoo", "Stieg Larsson", "978-0-307-27767-2"));
        livres.add(new Livre("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "978-0-345-39181-3"));
        livres.add(new Livre("The Kite Runner", "Khaled Hosseini", "978-1-59448-000-3"));
        livres.add(new Livre("The Road", "Cormac McCarthy", "978-0-307-38789-9"));
    }

    public static Bibliotheque getInstance(){
        if(instance == null)
            instance = new Bibliotheque();

        return instance;
    }
    /** SINGLETON **/
}
