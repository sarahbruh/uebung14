package model;

import java.util.ArrayList;

/**
 * uebung 14
 * @author Brunmayr Sarah
 * @version 12.0.1, 23.02.2021
 */

public class Adressbuch {

    private ArrayList<Eintrag> eintrage;

    private int currentIndex;


    public Adressbuch() {
        this.eintrage = new ArrayList<>();
        this.currentIndex = 0;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public void saveToCSV(){
        CSV csv = new CSV();
        csv.saveToFile("Adressbuch.csv",eintrage);
    }

    public void loadFromCSV(){
        CSV csv = new CSV();
        currentIndex = 0;
        eintrage = csv.loadFromFile("Adressbuch.csv");
    }
}
