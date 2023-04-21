package nl.avasten.H14;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;

public class Bank implements Iterable<Bank.BankAccount> {

  enum AccountType {
    CHECKINGSACCOUNT,
    SAVINGSACCOUNT
  }

  public ArrayList<BankAccount> bankAccountsList = new ArrayList<>();

  public void createBankAccount(AccountType accountType, BigDecimal balance, int id) {

    // TODO hoe helpt de factory method hier als er sprake is van
    // variabele hoeveelheid fields
    switch (accountType) {
      case CHECKINGSACCOUNT:
        this.bankAccountsList.add(new CheckingsAccount(balance, id));
      case SAVINGSACCOUNT:
        float interestRate = 5f;
        this.bankAccountsList.add(new SavingsAccount(balance, id, interestRate));
    }
  }

  public void listBankAccounts() {
    for (BankAccount i : bankAccountsList) {
      System.out.println(i.toString());
    }
  }

  public BankAccount findBankAccount(int accountNum) throws IllegalArgumentException {
    return bankAccountsList.stream()
        .filter(e -> accountNum == e.getAccountNumber())
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Fout banknummer"));
  }

  public BigDecimal getBalanceForBankAccount(int accountNum) {
    BankAccount account = findBankAccount(accountNum);
    return account.getBalance();
  }

  public BigDecimal calculateInterestForBankAccount(int accountNum) {
    BankAccount account = findBankAccount(accountNum);
    if (account instanceof SavingsAccount s) {
      return s.calculateInterest();
    } else {
      return null;
    }
  }

  public void transferMoney(int fromAccount, int toAccount, BigDecimal amount) {
    BankAccount fromBank;
    BankAccount toBank;

    try {
      fromBank = findBankAccount(fromAccount);
      toBank = findBankAccount(toAccount);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return;
    }

    // TODO Ask whether this can be shorted
    try {
      fromBank.withdrawal(amount);
      toBank.deposit(amount);
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  public void withdrawal(int accountNumber, BigDecimal amount)
      throws IllegalArgumentException, NumberFormatException {
    BankAccount fromBank;

    try {
      fromBank = findBankAccount(accountNumber);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException(e.getMessage());
    }

    // TODO Ask whether this can be shorted
    try {
      fromBank.withdrawal(amount);
    } catch (NumberFormatException e) {
      throw new NumberFormatException(e.getMessage());
    }
  }

  public void deposit(int accountNumber, BigDecimal amount)
      throws IllegalArgumentException, NumberFormatException {
    BankAccount toBank;

    try {
      toBank = findBankAccount(accountNumber);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException(e.getMessage());
    }

    try {
      toBank.deposit(amount);
    } catch (NumberFormatException e) {
      throw new NumberFormatException(e.getMessage());
    }
  }

  public BigDecimal getTotalInBankWithStream() {
    return this.bankAccountsList.stream()
        .map(BankAccount::getBalance)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  @Override
  public Iterator<BankAccount> iterator() {
    return new Iterator<BankAccount>() {

      int cursor;

      @Override
      public boolean hasNext() {
        return cursor < Bank.this.bankAccountsList.size();
      }

      @Override
      public BankAccount next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        return Bank.this.bankAccountsList.get(cursor++);
      }
    };
  }

  private static class CheckingsAccount extends BankAccount {
    public CheckingsAccount(BigDecimal balance, int accountNumber) {
      super(balance, accountNumber);
    }
  }

  private static class SavingsAccount extends BankAccount {
    private float interestRate;

    public SavingsAccount(BigDecimal balance, int accountNumber, float interestRate) {
      super(balance, accountNumber);
      this.interestRate = interestRate;
    }

    public BigDecimal calculateInterest() {

      BigDecimal interest = new BigDecimal("0.00");

      interest =
          super.balance
              .multiply(BigDecimal.valueOf(this.interestRate))
              .divide(new BigDecimal("100"))
              .setScale(2, BigDecimal.ROUND_HALF_UP);

      return interest;
    }
  }

  public abstract static class BankAccount {

    private final int accountNumber;
    private BigDecimal balance;

    public BankAccount() {
      this(new BigDecimal("0.00"));
    }

    public BankAccount(int accountNumber) {
      this(new BigDecimal("0.00"), accountNumber);
    }

    public BankAccount(BigDecimal balance) {
      this(balance, new Random().nextInt(0, 99999));
    }

    public BankAccount(BigDecimal balance, int accountNumber) {
      this.balance = balance;
      this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
      return this.accountNumber;
    }

    public BigDecimal getBalance() {
      return this.balance;
    }

    private void setBalance(BigDecimal amount) {
      this.balance = amount;
    }

    public void deposit(BigDecimal amount) {
      this.balance = this.balance.add(amount);
    }

    public void withdrawal(BigDecimal amount) throws IllegalArgumentException {
      BigDecimal newBalance = this.getBalance().subtract(amount);
      if (newBalance.compareTo(BigDecimal.ZERO) > 0) {
        this.setBalance(newBalance);
      } else {
        throw new IllegalArgumentException("Saldo is ontoereikend voor opname!");
      }
    }

    @Override
    public String toString() {

      NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
      currencyFormat.setCurrency(Currency.getInstance(Locale.getDefault()));

      return "BankAccount{"
          + "accountNumber = "
          + accountNumber
          + ", balance = "
          + currencyFormat.format(balance)
          + '}';
    }
  }
}
