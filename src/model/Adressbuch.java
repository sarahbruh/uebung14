package model;

import java.util.ArrayList;

/**
 * uebung 14
 * @author Brunmayr Sarah
 * @version 12.0.1, 23.02.2021
 */

public class Adressbuch {

    public ArrayList<Eintrag> eintrage = new ArrayList<>();

    public Adressbuch() {
        this.eintrage = new ArrayList<>();
    }
    public void lfCSV(){
        try{
            CSV csv = new CSV();
            eintrage = csv.loadFromFile("Adressbuch.csv");
        }
        catch(Exception ex){
            System.err.println("Error!12");
        }
    }

    public void stCSV(){
        try{
            CSV csv = new CSV();
            csv.saveToFile("Adressbuch.csv", eintrage);
        }
        catch(Exception ex){
            System.err.println("Error!");
        }
    }
}
