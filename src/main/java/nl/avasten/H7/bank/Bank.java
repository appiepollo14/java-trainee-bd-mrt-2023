package nl.avasten.H7.bank;

import java.math.BigDecimal;

public class Bank {

    public static BigDecimal totalInBank = new BigDecimal("0.00");

    private float interestRate;
    private int accountNumber;
    private BigDecimal balance;

    public Bank() {
        this.interestRate = 5.3f;
        System.out.println(this.interestRate);
        this.balance = new BigDecimal("0.00");
    }

    public Bank(BigDecimal balance) {
        this();
        this.balance = new BigDecimal(String.valueOf(balance));
    }

    public Bank(BigDecimal balance, int accountNumber) {
        this();
        this.balance = new BigDecimal(String.valueOf(balance));
        this.accountNumber = accountNumber;
    }

    public void deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void withdrawal(BigDecimal amount) {
        BigDecimal newBalance = this.getBalance().subtract(amount);
        if (newBalance.compareTo(BigDecimal.ZERO) > 0) {
            this.setBalance(newBalance);
        } else {
            throw new IllegalArgumentException("Saldo is ontoereikend voor opname!");
        }
    }

    public void transferMoney(Bank fromBank, BigDecimal amount) {
        try {
            fromBank.withdrawal(amount);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.deposit(amount);
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
