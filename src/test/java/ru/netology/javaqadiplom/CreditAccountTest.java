package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test
    public void createAccountWithNegativeBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -3_000,
                    500,
                    15
            );
        });
    }

    @Test
    public void shouldCountYearChangeCorrectly() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldCountYearChangeWithFraction() {
        CreditAccount account = new CreditAccount(
                -13,
                5_000,
                15
        );

        Assertions.assertEquals(1.95, account.yearChange());
    }

    @Test
    public void payExceedingLimit() {
        CreditAccount account = new CreditAccount(
                1_000,
                100,
                10);

        Assertions.assertEquals(false, account.pay(1_200));
    }
}
