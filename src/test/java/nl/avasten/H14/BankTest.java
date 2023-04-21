package nl.avasten.H14;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankTest {

  private Bank target;

  @BeforeEach
  public void init() {
    this.target = new Bank();
  }

  @Test
  void givenABankWithMultipleBankAccountWhenIteratingOverAccountsThenCountAccounts() {
    this.target.createBankAccount(Bank.AccountType.SAVINGSACCOUNT, new BigDecimal("122.2"), 1);
    this.target.createBankAccount(Bank.AccountType.SAVINGSACCOUNT, new BigDecimal("122.2"), 2);

    Assertions.assertThat(this.target.bankAccountsList).hasSize(2);
  }
}
