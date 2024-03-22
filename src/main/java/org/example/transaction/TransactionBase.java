package org.example.transaction;

import org.example.accounts.AccountBase;

public abstract class TransactionBase {
    private String Type;
    private AccountBase Accountsender;
    private AccountBase AccountGetter;
    private float amount;
    private String status;

    protected TransactionBase(String type, AccountBase Accountsender, AccountBase AccountGetter, float amount, String status) {
        Type = type;
        this.Accountsender = Accountsender;
        this.AccountGetter = AccountGetter;
        this.amount = amount;
        this.status = status;
    }
    public AccountBase getSenderAccount() {
        return Accountsender;
    }

    public AccountBase getGetterAccount() {
        return AccountGetter;
    }

    public String getType() {
        return Type;
    }

    public float getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
