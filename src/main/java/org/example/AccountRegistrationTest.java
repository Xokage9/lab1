package org.example;
import org.example.accounts.AccountBase;
import org.example.banks.Bank;
import org.example.banks.CentralBank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountRegistrationTest {
    private final CentralBank centralBank = new CentralBank();
    private final Bank bank = new Bank(
            0,52,0.13f,centralBank);
    @Test
    public void shouldRegister() {
        centralBank.registerBank(bank);
        AccountBase account = bank.registerDebitAccount("Antoshka", "Churkin", 666,bank);

        Assertions.assertTrue(bank.getAccounts().contains(account));
    }
}