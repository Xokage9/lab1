package org.example.banks;

import org.example.transaction.TransactionBase;

import java.util.ArrayList;
import java.util.HashMap;

public class CentralBank {
    private int Ids;
    private ArrayList<Bank> banks;
    public void accelerationOfTime(int days) {
        for (int i = 0; i < days; i++)
            banks.forEach(Bank::updatePersense);
    }
    public void registerBank(Bank bank) {
        bank.setID(Ids);
        Ids++;
        banks.add(bank);
    }
    public void processTransaction(TransactionBase transaction){
        transaction.setStatus("finished");
    }
}