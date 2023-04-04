package nl.avasten.chainStoreMicro;

public class Main {

  public static void main(String[] args) {
    CardManager cardManager = new CardManager();
    cardManager.addCard(1235, "Gerda", 1000, 0);
    cardManager.addCard(1236, "Donald", 7000, 10);
    cardManager.addCard(1237, "Edward", 5000, 0);
    cardManager.addCard(1238, "Mona", 7000, 10);
    cardManager.addCard(1239, "Roan", 800, 15);
    cardManager.addCard(1240, "Vera", 500, 0);

    cardManager.runMicro();
  }
}
