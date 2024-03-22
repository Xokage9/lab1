package org.example.transaction;

import org.example.accounts.AccountBase;

public class TransactionDebite extends TransactionBase {

    public TransactionDebite(AccountBase Accountsender, float amount, String status) {
        super("Debite",Accountsender, Accountsender,amount, status);
    }

}
