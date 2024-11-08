package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    //1) В методе "add" amount должен суммироваться с initialBalance, а не присваиваться balance
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

    //2) По идее "сумма процентов" приводится к целому числу, т.е. конечный результат должен приводится к типу int, а не в промежуточных уже отбрасываться дробная часть -> ошибка в вычислениях
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

    //3) Изменение баланса счета происходит в любом случае, если amount<=0, т.к. изменение баланса происходит перед проверкой условия изменения
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

    //4) Должно быть исключение, если  minBalance < 0, однако его нет (добавить его в if  к rate<0)
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

    //5) Должно быть исключение, если  minBalance >= maxBalance, однако его нет (добавить его в if  к rate<0)
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

    //6) Должно быть исключение, если  initialBalance > maxBalance (по логике), однако его нет (добавить его в if  к rate<0)
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

    //7) Ожидается, что итоговый balance может быть равен minBalance, т.к. "сберегательный счёт может иметь баланс только в пределах от указанного минимального до указанного максимального включительно."
    //для этого сделать нестрогим проверку в строке 49 (if (balance >= minBalance))
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

    //8) В методе "add" amount должен суммироваться с initialBalance, а не присваиваться balance +
    //+ сделать нестрогим условие (if (balance + amount < maxBalance)) по ТЗ включительно
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
}
