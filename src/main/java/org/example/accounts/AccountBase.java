package org.example.accounts;

import org.example.banks.Bank;
import org.example.transaction.TransactionBase;
import org.example.transaction.TransactionDebite;
import org.example.transaction.TransactionDeliver;
import org.example.transaction.TransactionDeposit;

import java.util.ArrayList;
import java.util.List;

public abstract class AccountBase {
    private String name;
    private String surname;
    private Bank bank;
    private int idAccount;
    private float balance;
    List<TransactionBase>historyTransaction = new ArrayList<>();

    protected AccountBase(String name, String surname, Bank bank, int idAccount, float balance) {
        this.name = name;
        this.surname = surname;
        this.bank = bank;
        this.idAccount = idAccount;
        this.balance = balance;
    }
    protected AccountBase(String name, String surname, Bank bank, int idAccount) {
        this(name,surname,bank,idAccount, 0 );
    }
    public String getName() {
        return name;
    }
    public List<TransactionBase> getHistory(){
        return historyTransaction;
    }

    public String getSurname() {
        return surname;
    }

    public Bank getIDbank() {
        return bank;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
    public void putMoney(float money){
        balance+=money;
    }
    public void takeMoney(float money){
        if (balance < money){
            throw new IllegalStateException("net deneg");
        }
        balance-=money;
    }
    public void debiteMoney(float money){
        takeMoney(money);
        TransactionBase transactionBase = new TransactionDebite(this, money,"active");
        historyTransaction.add(transactionBase);
    }
    public void depositmoney(float money){
        takeMoney(money);
        TransactionBase transactionBase = new TransactionDeposit(this, money,"active");
        historyTransaction.add(transactionBase);
    }
    public void delivermoney(float money, AccountBase secondaccount){
        TransactionBase transactionBase = new TransactionDeliver(this,secondaccount,money,"active");
        historyTransaction.add(transactionBase);
    }

}
