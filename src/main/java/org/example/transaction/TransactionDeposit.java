package org.example.transaction;

import org.example.accounts.AccountBase;

public class TransactionDeposit extends TransactionBase {
    public TransactionDeposit(AccountBase Accountsender, float amount, String status) {
        super("Deposit", Accountsender, Accountsender, amount, status);
    }

}
