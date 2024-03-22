package org.example.banks;

import org.example.accounts.*;
import org.example.transaction.TransactionBase;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Bank {
    private int idaccounts;
    private float penni;
    private float procenti;
    private final HashMap<AccountBase, Float> remains = new HashMap<>();
    private ArrayList<AccountBase> accounts = new ArrayList<>();
    private int ID;
    private CentralBank centralBank;

    public Bank(int id, float Penni, float Procenti, CentralBank centralBank) {
        ID = id;
        penni = Penni;
        procenti = Procenti;
        this.centralBank = centralBank;
    }

    public void updatePersense(){
        for (AccountBase account : accounts ) {
            if (account instanceof DebetAccount) {
                float percent = remains.get(account);
                remains.put(account,percent + account.getBalance()*procenti);
            }
            if (account instanceof DepositAccount){
                float percent = remains.get(account);
                remains.put(account,percent + account.getBalance()*procenti);
            }
        }
    }
    public void takePenni() {
        for(AccountBase account : accounts) {
            if (account instanceof CreditAccount) {
                float balance = account.getBalance();
                account.setBalance(balance - penni);
            }
        }
    }
    public void payRemains() {
        for (AccountBase account : remains.keySet()) {
            float balance = account.getBalance();
            account.setBalance(balance + remains.get(account));
        }
    }

    public int getID() {
        return ID;
    }
    public int setID(int ID){
        this.ID = ID;
        return ID;
    }
    public void processTransaction(TransactionBase transaction) {
        if (transaction.getType().equals("Deliver")) {
            float amount = transaction.getAmount();
            transaction.getSenderAccount().takeMoney(amount);
            transaction.getGetterAccount().putMoney(amount);
        }
        centralBank.processTransaction(transaction);
    }
    public void cancelTransaction(TransactionBase transaction){
        if(transaction.getType().equals("Deliver")){
            float amount = transaction.getAmount();
            transaction.getSenderAccount().putMoney(amount);
            transaction.getGetterAccount().takeMoney(amount);
        }
        if (transaction.getType().equals("Deposit")){
            float amount = transaction.getAmount();
            transaction.getGetterAccount().takeMoney(amount);
        }
        if (transaction.getType().equals("Debite")){
            float amount = transaction.getAmount();
            transaction.getSenderAccount().putMoney(amount);
        }
    }
    public AccountBase registerDebitAccount(String name,String surname, float amount, Bank bank) {
        AccountBase account = AccountFactory.createDebetAccount(name, surname,bank,idaccounts++,amount);
        accounts.add(account);
        remains.put(account, 0f);
        return account;
    }

    public AccountBase registerDepositAccount(String name,String surname, float amount, Bank bank) {
        AccountBase account = AccountFactory.createDebetAccount(name, surname,bank,idaccounts++,amount);
        accounts.add(account);
        remains.put(account, 0f);
        return account;
    }

    public AccountBase registerCreditAccount(String name,String surname, float amount, Bank bank) {
        AccountBase account = AccountFactory.createDebetAccount(name, surname,bank,idaccounts++,amount);
        accounts.add(account);
        remains.put(account, 0f);
        return account;
    }

    public List<AccountBase> getAccounts() {
        return accounts;
    }
}
