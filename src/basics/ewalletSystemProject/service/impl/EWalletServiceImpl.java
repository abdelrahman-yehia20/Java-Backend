package main.ewalletSystem.ewalletSystemProject.service.impl;

import main.ewalletSystem.ewalletSystemProject.model.Account;
import main.ewalletSystem.ewalletSystemProject.service.AccountService;
import main.ewalletSystem.ewalletSystemProject.service.AccountValidationService;
import main.ewalletSystem.ewalletSystemProject.service.ApplicationService;

import java.util.Objects;
import java.util.Scanner;

public class EWalletServiceImpl implements ApplicationService {

    private AccountService accountService = new AccountServiceImpl();

    private AccountValidationService accountValidationService = new AccountValidationServiceImpl();
    @Override
    public void startApp() {
        System.out.println("welcome sir :)");
        boolean isExist = false;
        int counter = 0;
        while (true) {
            System.out.println("pls enter your service :)");
            System.out.println("1.login           2.signup             3.Exit");
            Scanner scanner = new Scanner(System.in);
            int service = scanner.nextInt();

            switch (service) {
                case 1:
                    login();
                    break;
                case 2:
                    signup();
                    break;
                case 3:
                    System.out.println("have a nice day :)");
                    isExist = true;
                    break;
                default:
                    System.out.println("invalid choose :(");
                    counter++;
            }

            if (isExist) {
                break;
            }

            if (counter == 3) {
                System.out.println("pls contact with admin :(");
                break;
            }
        }
    }

    private void login(){
        Account account = getAccount(true);

        if (Objects.isNull(account)) {
            return;
        }
        boolean loginSuccess = accountService.getAccountByUserNameAndPassword(account);
        if (loginSuccess) {
            System.out.println("success login :)");
            profile(account);
        } else {
            System.out.println("invalid username or password :(");
        }

    }

    private void signup(){
        Account account = getAccount(false);

        if (Objects.isNull(account)) {
            return;
        }
        // service to add account on EWallet system
        boolean isAccountCreated = accountService.createAccount(account);

        if (isAccountCreated) {
            System.out.println("account created success :)");
            profile(account);
        } else {
            System.out.println("account already exist with same username or phoneNumber" + account.getUserName() + "-" +account.getPhoneNumber());
        }
    }

    private Account getAccount(boolean login){

        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter your username: ");
        String userName = sc.next();

        if (!accountValidationService.validateUserName(userName)) {
            System.out.println("invalid user name ..........");
            return null;
        }

        System.out.print("Please enter your password: ");
        String password = sc.next();

        if (!accountValidationService.validatePassword(password)) {
            System.out.println("invalid password ..........");
            return null;
        }

        if (login) {
            return new Account(userName, password);
        }

        System.out.print("Please enter your phone number: ");
        String phoneNumber = sc.next();

        System.out.print("Please enter your address: ");
        String address = sc.next();

        System.out.print("Please enter your age: ");
        float age = sc.nextFloat();
        if (!accountValidationService.validateAge(age)){
            System.out.println("invalid age ......");
            return null;
        }

        return new Account(userName, password, phoneNumber, address, age);
    }


    private void profile(Account account){
        boolean logout = false;
        int counter = 0;
        while (true) {
            System.out.println("----------> services <------------");
            System.out.println("1.deposit     2.withdraw   3.show account details    4.transfer      5.change password       6.logout");
            Scanner scanner = new Scanner(System.in);
            System.out.println("pls give me service you need to apply.");
            int result = scanner.nextInt();

            switch (result) {
                case 1:
                    deposit(account);
                    break;
                case 2:
                    withdraw(account);
                    break;
                case 3:
                    showAccountDetails(account);
                    break;
                case 4:
                    transfer(account);
                    break;
                case 5:
                    changePassword(account);
                    break;
                case 6:
                    System.out.println("have a nice day :)");
                    logout = true;
                    break;
                default:
                    System.out.println("invalid service");
                    counter++;
            }
            if (logout){
                break;
            }

            if (counter == 3) {
                System.out.println("pls contact with admin :(");
                break;
            }
        }
    }

    public void changePassword(Account account){
        // Step 1: Ask for old password
        // Step 2: Validate old password
        // Step 3: Ask for new password
        // Step 4: Validate new password format
        // Step 5: Prevent using same old password
        // Step 6: Update password
        // Step 7: Success message
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("pls enter the old password");
            String oldPassword = scanner.next();
            accountService.changePassword(account, oldPassword);
        }catch (RuntimeException e) {
            System.out.println("exception message: " + e.getMessage());
        }

    }

    public void transfer(Account accountFrom){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("pls enter the userName Account you want to transfer money to him");
            String userNameOfAccountTo = scanner.next();
            System.out.println("pls enter the amount you need to transfer");
            double amount = scanner.nextDouble();
            Account accountTo  = accountService.geteWalletSystem().getAccounts().stream().filter(acc1->acc1.getUserName().equals(userNameOfAccountTo)).findFirst().get();
            accountService.transfer(accountFrom, accountTo, amount);
        }catch (RuntimeException e) {
            System.out.println("exception message: " + e.getMessage());
        }

    }

    private void showAccountDetails(Account account) {
        Account accountExist = accountService.getAccountByUserName(account);
        if (Objects.isNull(accountExist)) {
            System.out.println("account not exist :(");
            return;
        }
        System.out.println(account);
    }

    private void withdraw(Account account) {
        System.out.println("pls enter amount you need to withdraw");
        try {
            Scanner scanner = new Scanner(System.in);
            double amount = scanner.nextDouble();
            accountService.withdraw(account, amount);
        }catch (RuntimeException e) {
            System.out.println("exception message: " + e.getMessage());
        }
    }

    private void deposit(Account account) {
        System.out.println("pls enter amount you need to deposit");
        try {
            Scanner scanner = new Scanner(System.in);
            double amount = scanner.nextDouble();
             accountService.deposit(account, amount);
        }catch (RuntimeException e) {
            System.out.println("exception message: " + e.getMessage());
        }


    }
}
