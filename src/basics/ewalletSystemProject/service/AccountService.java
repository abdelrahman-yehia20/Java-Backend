package main.ewalletSystem.ewalletSystemProject.service;

import main.ewalletSystem.ewalletSystemProject.model.Account;
import main.ewalletSystem.ewalletSystemProject.model.EWalletSystem;

public interface AccountService {
    boolean createAccount(Account account);
    boolean getAccountByUserNameAndPassword(Account account);
    Account getAccountByUserName(Account account);
    public EWalletSystem geteWalletSystem();

    Account deposit(Account account, double amount);
    Account withdraw(Account account, double amount);
    Account transfer(Account accountFrom, Account accountTo, double amount);
    void changePassword(Account account,String oldPassword);
}
