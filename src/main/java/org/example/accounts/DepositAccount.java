package org.example.accounts;

import org.example.banks.Bank;

public class DepositAccount extends AccountBase{
    protected DepositAccount(String name, String surname, Bank bank, int idAccount, float balance) {
        super(name, surname, bank, idAccount, balance);
    }

    protected DepositAccount(String name, String surname, Bank bank, int idAccount) {
        super(name, surname, bank, idAccount);
    }
}
