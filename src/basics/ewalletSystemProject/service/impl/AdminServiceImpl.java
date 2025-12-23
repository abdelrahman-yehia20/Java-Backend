package main.ewalletSystem.ewalletSystemProject.service.impl;

import main.ewalletSystem.ewalletSystemProject.model.Account;
import main.ewalletSystem.ewalletSystemProject.model.EWalletSystem;
import main.ewalletSystem.ewalletSystemProject.service.AdminService;

import java.util.Iterator;

public class AdminServiceImpl implements AdminService {

    private EWalletSystem eWalletSystem;
    public AdminServiceImpl(EWalletSystem eWalletSystem){
        this.eWalletSystem = eWalletSystem;
    }
    @Override
    public void viewAllAccounts() {
        eWalletSystem.getAccounts().forEach(System.out::println);
    }

    @Override
    public void viewAllHistories() {
        eWalletSystem.getHistories().forEach((user,histories)->{
            System.out.println("user:" +user);
            histories.forEach(System.out::println);
        });
    }

    @Override
    public boolean deleteAccount(String userName) {


        Iterator<Account> iterator = eWalletSystem.getAccounts().iterator();
        boolean removed = false;

        while (iterator.hasNext()) {
            Account account = iterator.next();
            if (account.getUserName().equals(userName)) {
                iterator.remove();
                removed = true;
                break;
            }
        }
        if (removed) {
            eWalletSystem.getHistories().remove(userName);
        }
        return removed;
    }
}
