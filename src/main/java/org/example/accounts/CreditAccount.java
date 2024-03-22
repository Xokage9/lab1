package org.example.accounts;

import org.example.banks.Bank;

public class CreditAccount extends AccountBase{
    protected CreditAccount(String name, String surname, Bank bank, int idAccount, float balance) {
        super(name, surname, bank, idAccount, balance);
    }

    protected CreditAccount(String name, String surname, Bank bank, int idAccount) {
        super(name, surname, bank, idAccount);
    }
}
