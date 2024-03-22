package org.example.accounts;

import org.example.banks.Bank;

public class AccountFactory {
    public static AccountBase createDepositAccount(String name, String surname, Bank bank, int IdAccount, float balance){
        return new DepositAccount(name, surname, bank,IdAccount,balance);

    }
    public static AccountBase createDebetAccount(String name, String surname, Bank bank, int IdAccount, float balance){
        return new DebetAccount(name, surname,bank,IdAccount,balance);
    }
    public static AccountBase createCreditAccount(String name, String surname, Bank bank, int IdAccount, float balance){
        return new CreditAccount(name, surname,bank,IdAccount,balance);
    }
}
