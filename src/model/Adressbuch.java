package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/**
 * uebung 14 & 15
 * @author Brunmayr Sarah
 * @version 12.0.1, 23.02.2021
 */

public class Adressbuch {

    public ArrayList<Eintrag> eintrage;

    public Adressbuch() {
        try {
            this.eintrage = new ArrayList<>();
            if (file.createNewFile()) {
                System.out.println("Datei hinzugefügt");
            }
        }
        catch(Exception ex){
            System.err.println();

        }
    }
    final String PATH = System.getProperty("user.dir") + "\\Adressbuch.csv";
    File file = new File(PATH);

    public void lfCSV(){
        try{
            CSV csv = new CSV();
            eintrage = csv.loadFromFile("Adressbuch.csv");
            Collections.sort(eintrage);
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
