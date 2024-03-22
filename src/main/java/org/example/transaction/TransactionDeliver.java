package org.example.transaction;

import org.example.accounts.AccountBase;

public class TransactionDeliver extends TransactionBase {
    public TransactionDeliver(AccountBase Accountsender, AccountBase AccountGetter, float amount, String status) {
        super("Deliver", Accountsender, AccountGetter, amount, status);
    }
}
