package nl.avasten.H7.bank;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Random;

public class BankAccount {

    private final int accountNumber;
    private BigDecimal balance;
    private float interestRate;

    public BankAccount() {
        this(new BigDecimal("0.00"));
    }

    public BankAccount(int accountNumber) {
        this(5.3f, new BigDecimal("0.00"), accountNumber);
    }

    public BankAccount(BigDecimal balance) {
        this(5.3f, balance, new Random().nextInt(0, 99999));
    }

    public BankAccount(float interestRate, BigDecimal balance, int accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.interestRate = interestRate;
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

    public void withdrawal(BigDecimal amount) throws IllegalArgumentException{
        BigDecimal newBalance = this.getBalance().subtract(amount);
        if (newBalance.compareTo(BigDecimal.ZERO) > 0) {
            this.setBalance(newBalance);
        } else {
            throw new IllegalArgumentException("Saldo is ontoereikend voor opname!");
        }
    }

    public BigDecimal calculateInterest() {

        BigDecimal interest = new BigDecimal("0.00");

        interest = this.balance
                .multiply(BigDecimal.valueOf(this.interestRate))
                .divide(new BigDecimal("100"))
                .setScale(2, BigDecimal.ROUND_HALF_UP);

        return interest;
    }

    @Override
    public String toString() {

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        currencyFormat.setCurrency(Currency.getInstance(Locale.getDefault()));

        return "BankAccount{" +
                "accountNumber = " + accountNumber +
                ", balance = " + currencyFormat.format(balance) +
                ", interestRate = " + interestRate +
                ", yearlyInterest = " + currencyFormat.format(calculateInterest()) +
                '}';
    }

}
