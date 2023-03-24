package nl.avasten.H7.bank;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Bank {

    public BigDecimal totalInBank = new BigDecimal("0.00");
    public ArrayList<BankAccount> bankAccountsList = new ArrayList<>();

    public void createBankAccount() {
        this.bankAccountsList.add(new BankAccount());
    }

    public void createBankAccount(int accountNumber) {
        this.bankAccountsList.add(new BankAccount(accountNumber));
    }

    public void listBankAccounts() {
        for (BankAccount i: bankAccountsList) {
            System.out.println(i.toString());
        }
    }

    public BankAccount findBankAccount(int accountNum) throws IllegalArgumentException {
        return bankAccountsList.stream()
                .filter(e -> accountNum == e.getAccountNumber())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Fout banknummer"));
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

        //TODO Ask whether this can be shorted
        try {
            fromBank.withdrawal(amount);
            toBank.deposit(amount);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdrawal(int accountNumber, BigDecimal amount) throws IllegalArgumentException, NumberFormatException {
        BankAccount fromBank;

        try {
            fromBank = findBankAccount(accountNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        //TODO Ask whether this can be shorted
        try {
            fromBank.withdrawal(amount);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(e.getMessage());
        }
        this.totalInBank = this.totalInBank.subtract(amount);
    }

    public void deposit(int accountNumber, BigDecimal amount) throws IllegalArgumentException, NumberFormatException {
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
        this.totalInBank = this.totalInBank.add(amount);
    }

    public BigDecimal getTotalInBank() {
        return this.totalInBank;
    }

}
