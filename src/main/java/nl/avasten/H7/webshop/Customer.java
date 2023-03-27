package nl.avasten.H7.webshop;

public class Customer {

    private String name;
    private String placeOfResidence;


    public Customer(String name, String placeOfResidence) {
        this.name = name;
        this.placeOfResidence = placeOfResidence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceOfResidence() {
        return placeOfResidence;
    }

    public void setPlaceOfResidence(String placeOfResidence) {
        this.placeOfResidence = placeOfResidence;
    }
}
