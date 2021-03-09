package model;

/**
 * uebung 14 & 15
 * @author Brunmayr Sarah
 * @version 12.0.1, 23.02.2021
 */

public class Eintrag implements Comparable<Eintrag>{

    private String name;
    private String address;
    private String phone;

    public Eintrag(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    @Override
    public int compareTo(Eintrag eintrag){
        int erg;
        if ((erg = this.name.compareTo((eintrag.getName()))) == 0){
            if ((erg = this.phone.compareTo(eintrag.getPhone())) == 0){
                return this.address.compareTo(eintrag.getAddress());
            }
        }
        return erg;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
