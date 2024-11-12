package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2000 + 3_000, account.getBalance());
    }

    @Test
    public void countYearChange() {
        SavingAccount account = new SavingAccount(
                350,
                100,
                10_000,
                15
        );

        Assertions.assertEquals(52, account.yearChange());
    }

    @Test
    public void countPay() {
        SavingAccount account = new SavingAccount(
                3000,
                100,
                10_000,
                15
        );

        account.pay(2950);
        Assertions.assertEquals(3000, account.getBalance());
    }

    @Test
    public void createAccountWithNegativeMinBalance() {


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2000,
                    -1000,
                    500,
                    10
            );
        });
    }

    @Test
    public void createAccountWithMinBalanceLargerThanMinBalance() {


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    6000,
                    10000,
                    8000,
                    10
            );
        });
    }

    @Test
    public void createAccountWithInitBalanceLargerThanMaxBalance() {


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    6000,
                    1000,
                    5000,
                    10
            );
        });
    }

    @Test
    public void countPayBalanceEqualsMinBalance() {
        SavingAccount account = new SavingAccount(
                3000,
                100,
                10_000,
                15
        );

        Assertions.assertEquals(true, account.pay(2900));
    }

    @Test
    public void shouldAddEqMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertEquals(true, account.add(8_000));
    }

    @Test
    public void createAccountWithInitBalanceLessThanMinBalance() {


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    3000,
                    4000,
                    5000,
                    10
            );
        });
    }
}
