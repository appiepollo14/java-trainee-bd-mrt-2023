package nl.avasten._INPROJAV.strings;

public class Strings {

    private String string;

    public Strings() {
        this.string = "Roald";
    }

    public void concat() {
        this.string.concat("blaaa");
        System.out.println(this.string);
    }

    public void contains() {
        StringBuilder containsNld = new StringBuilder();
        containsNld.append("Does the string contain \"boa\"? ");
        containsNld.append(this.string.contains("boa"));
        System.out.println(containsNld.toString());

        StringBuilder containsLd = new StringBuilder();
        containsLd.append("Does the string contain \"oa\"? ");
        containsLd.append(this.string.contains("oa"));
        System.out.println(containsLd.toString());
    }

    public void endsWith() {
        StringBuilder endsWith = new StringBuilder();
        endsWith.append("Does the string ends with \"ld\"? ");
        endsWith.append(this.string.endsWith("ld"));
        System.out.println(endsWith.toString());
    }

    public void equals() {
        StringBuilder equals = new StringBuilder();
        equals.append("Does the string equals \"roald\"? ");
        equals.append(this.string.equals("roald"));
        System.out.println(equals.toString());
    }
    public void equalsIgnoreCase() {
        StringBuilder equalsIgnoreCase = new StringBuilder();
        equalsIgnoreCase.append("Does the string equals ignore case \"roald\"? ");
        equalsIgnoreCase.append(this.string.equalsIgnoreCase("roald"));
        System.out.println(equalsIgnoreCase.toString());
    }

}
