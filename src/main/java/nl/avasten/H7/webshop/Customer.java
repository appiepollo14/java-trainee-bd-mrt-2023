package nl.avasten.H7.webshop;

public record Customer(String name, String placeOfResidence) {
  @Override
  public String toString() {
    return " Naam='" + name + '\'' + ", Woonplaats:'" + placeOfResidence + '\'' + '}';
  }
}
