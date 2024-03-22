package org.example.accounts;

import org.example.banks.Bank;

public class DebetAccount extends AccountBase{

    protected DebetAccount(String name, String surname, Bank bank, int idAccount, float balance) {
        super(name, surname, bank, idAccount, balance);
    }

    protected DebetAccount(String name, String surname, Bank bank, int idAccount) {
        super(name, surname, bank, idAccount);
    }

}
