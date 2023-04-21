package nl.avasten.H14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcordanceTest {

  private Concordance sut;

  @BeforeEach
  public void init() {
    this.sut = new Concordance();
  }

  @Test
  void createConcordance() {
    this.sut.createConcordance("Hello World");
  }
}
