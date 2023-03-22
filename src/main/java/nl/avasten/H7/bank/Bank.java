package nl.avasten.H7.bank;

import java.math.BigDecimal;

public class Bank {

    private float interestRate;

    private int accountNumber;
    private BigDecimal balance;

    public Bank() {
        this.interestRate = 5f;
        //this.balance = new BigDecimal(0);
    }

    public Bank(BigDecimal balance) {
        this();
        this.balance = balance;
    }

}
