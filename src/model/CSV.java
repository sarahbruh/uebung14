package model;

import java.io.*;
import java.util.ArrayList;

/**
 * uebung 14 & 15
 * @author Brunmayr Sarah
 * @version 12.0.1, 23.02.2021
 */

public class CSV {

    public  void saveToFile(String fileName, ArrayList<Eintrag> eintrage) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            fileWriter.write("Name;Adresse;Telefonnummer");
            bufferedWriter.newLine();

            for (Eintrag eintrag:eintrage) {
                bufferedWriter.write(eintrag.getName() + ";" + eintrag.getAddress() + ";" + eintrag.getPhone() + ";");
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }
        catch (IOException ex){
            System.err.println("Error!");
        }
    }
    public ArrayList<Eintrag> loadFromFile(String fileName) {
        ArrayList<Eintrag> eintrage = new ArrayList<>();
        String[] s;
        String line;
        try {
            BufferedReader bufferedReader =new BufferedReader(new FileReader(fileName));
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                s = line.split(";");
                Eintrag e = new Eintrag(s[0],s[1],s[2]);
                eintrage.add(e);
            }
            bufferedReader.close();
        }
        catch (IOException io) {
            System.err.println("Error! Try again!");
        }
        return eintrage;
    }
}
