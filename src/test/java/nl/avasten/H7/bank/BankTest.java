package nl.avasten.H7.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    private Bank bank1;
    private Bank bank2;
    private Bank bank3;
    private Bank bank4;
    private Bank bank5;
    private Bank bank6;
    private Bank bank7;
    private Bank bank8;
    private Bank bank9;
    private Bank bank10;

    @BeforeEach
    public void init() {
        this.bank1 = new Bank(new BigDecimal(0), 34312);
        this.bank2 = new Bank(new BigDecimal(0), 32192);
        this.bank3 = new Bank(new BigDecimal(0), 55320);
        this.bank4 = new Bank(new BigDecimal(0), 23198);
        this.bank5 = new Bank(new BigDecimal(0), 99341);
        this.bank6 = new Bank(new BigDecimal(0), 56213);
        this.bank7 = new Bank(new BigDecimal(0), 66234);
        this.bank8 = new Bank(new BigDecimal(0), 12345);
        this.bank9 = new Bank(new BigDecimal(0), 84245);
        this.bank10 = new Bank(new BigDecimal(0), 23667);
    }

    @Test
    void givenABankDepositMoneyCheckNewBalance() {
        bank1.deposit(new BigDecimal("78899"));
        assertTrue(Objects.equals(bank1.getBalance(), new BigDecimal("78899")));
    }

    @Test
    void withdrawal() {
    }

    @Test
    void transferMoney() {
    }
}