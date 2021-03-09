package controllerview;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Adressbuch;
import model.Eintrag;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * uebung 14
 * @author Brunmayr Sarah
 * @version 12.0.1, 23.02.2021
 */

public class Controller implements Initializable {

    @FXML
    private TextField name;

    @FXML
    private TextField address;

    @FXML
    private TextField phone;

    @FXML
    private Text page;

    private Adressbuch adressbuch = new Adressbuch();
    int index;

    @FXML
    public void previous() {

        try {
            showEntry(index - 1);
            index--;
        }
        catch(Exception ex){
            System.err.println("Page not available! This is the last page!");
        }
    }

    @FXML
    public void add() {
        String nameS = name.getText();
        String addressS = address.getText();
        String phoneS = phone.getText();

        Eintrag e = new Eintrag(nameS, addressS, phoneS);

        //Collections.sort(adressbuch.eintrage, Eintrag.);
        //adressbuch.eintrage.sort(Eintrag::compareToIgnoreCase);
        try {
            adressbuch.eintrage.add(e);
            showEntry(index);
        }
        catch (Exception ex){
            System.err.println("Error!");
        }
    }

    @FXML
    public void loadFromCSV() {
        try {
            adressbuch.lfCSV();
            showEntry(index);
        }
        catch(Exception ex){
            System.err.println("Error!");
        }
    }

    @FXML
    public void delete() {
        try {
            adressbuch.eintrage.remove(index);
            name.clear();
            address.clear();
            phone.clear();
            showEntry(index);
        }
        catch(Exception ex){
            System.err.println("Error! Nothing to delete!");
        }
    }

    @FXML
    public void next() {
        try {
            showEntry(index + 1);
            index++;
        }
        catch(Exception ex){
            System.err.println("Page not available! This is the last page!");
        }
    }

    @FXML
    public void saveChanges() {
        try {
            Eintrag e = adressbuch.eintrage.get(index);

            String nameS = e.getName();
            String addressS = e.getAddress();
            String phoneS = e.getPhone();
            String nameC = name.getText();
            String addressC = address.getText();
            String phoneC = phone.getText();

            if (nameS.equals(nameC) && addressS.equals(addressC) && phoneS.equals(phoneC)){
                System.err.println("Nothing was changed!");
            }
            else{
                e.setName(nameC);
                e.setAddress(addressC);
                e.setPhone(phoneC);
            }
        }
        catch (Exception ex){
            System.err.println("Error! Nothing to save!");
        }
    }

    @FXML
    public void saveToCSV() {
        try {
            adressbuch.stCSV();
            showEntry(index);
        }
        catch(Exception ex){
            System.err.println("Error!");
        }
    }

    @FXML
    public void onlyNumbers(){
        phone.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    phone.setText(oldValue);
                }
            }
        });
    }

    private void showEntry (int x){
        name.setText(adressbuch.eintrage.get(x).getName());
        address.setText(adressbuch.eintrage.get(x).getAddress());
        phone.setText(adressbuch.eintrage.get(x).getPhone());
        page.setText(x+1+"/"+adressbuch.eintrage.size());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadFromCSV();
        onlyNumbers();
    }
}
