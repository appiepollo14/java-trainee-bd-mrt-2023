package nl.avasten.H11.bank;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankTest {

  private Bank target;

  //    private Bank.BankAccount bank = new Bank.BankAccount();

  @BeforeEach
  public void init() {
    int[] accountsList = {20309, 10124, 88292, 33088, 42605, 23133, 58923, 99231, 12234, 91821};
    BigDecimal[] moneyArray = {
      new BigDecimal("230.12"),
      new BigDecimal("123.50"),
      new BigDecimal("9923.99"),
      new BigDecimal("120.24"),
      new BigDecimal("7782.12"),
      new BigDecimal("112.78"),
      new BigDecimal("230.12"),
      new BigDecimal("823"),
      new BigDecimal("23"),
      new BigDecimal("20.00")
    };
    target = new Bank();
    for (int i = 0; i < 10; i++) {
      target.createBankAccount(Bank.AccountType.SAVINGSACCOUNT, moneyArray[i], accountsList[i]);
    }
  }

  @Test
  public void givenAListOfBankAccountsWhenCalculatingTotalInBankThanCheckResult() {
    BigDecimal expected = new BigDecimal("19388.87");
    assertEquals(expected, target.getTotalInBankWithStream());
  }

  @Test
  public void givenABankAccountThatDoesntExistWhenAddingMoneyThenError() {
    assertThrows(
        IllegalArgumentException.class, () -> target.withdrawal(12211, new BigDecimal("100.00")));
  }

  @Test
  void transferMoney() {
    BigDecimal expectedTotalInBank = new BigDecimal("19488.87");
    BigDecimal expectedBalanceToBank = new BigDecimal("330.12");
    target.deposit(20309, new BigDecimal("100.00"));

    assertEquals(expectedTotalInBank, target.getTotalInBankWithStream());
    assertEquals(expectedBalanceToBank, target.getBalanceForBankAccount(20309));
  }

  @Test
  void listBankAccounts() {
    target.listBankAccounts();
  }

  @Test
  void testWithdrawal() {
    BigDecimal expectodTotalBalance = new BigDecimal("19488.87");
    BigDecimal expectedBalanceToBank = new BigDecimal("330.12");
    target.deposit(20309, new BigDecimal("400.00"));
    target.withdrawal(20309, new BigDecimal("300.00"));

    assertEquals(expectodTotalBalance, target.getTotalInBankWithStream());
    assertEquals(expectedBalanceToBank, target.getBalanceForBankAccount(20309));
  }

  @Test
  void givenABankAccountWhenWithdrawingMoreThanBalanceThenError() {
    target.deposit(20309, new BigDecimal("400.00"));
    assertThrows(
        IllegalArgumentException.class, () -> target.withdrawal(20309, new BigDecimal("700.00")));
  }

  @Test
  void givenABankAccountWhenCalculatingInterestThenResultEquals() {

    target.deposit(20309, new BigDecimal("400.00"));
    BigDecimal calculatedInterest = target.calculateInterestForBankAccount(20309);
    BigDecimal expectedInterest = new BigDecimal("31.51");

    assertEquals(expectedInterest, calculatedInterest);
  }
}
