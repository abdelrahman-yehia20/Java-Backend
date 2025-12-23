    package main.ewalletSystem.ewalletSystemProject.service.impl;

    import main.ewalletSystem.ewalletSystemProject.exception.AccountNotFoundException;
    import main.ewalletSystem.ewalletSystemProject.exception.InsufficientBalanceException;
    import main.ewalletSystem.ewalletSystemProject.exception.InvalidAmountException;
    import main.ewalletSystem.ewalletSystemProject.exception.InvalidPasswordException;
    import main.ewalletSystem.ewalletSystemProject.helper.AccountResult;
    import main.ewalletSystem.ewalletSystemProject.model.Account;
    import main.ewalletSystem.ewalletSystemProject.model.EWalletSystem;
    import main.ewalletSystem.ewalletSystemProject.model.History;
    import main.ewalletSystem.ewalletSystemProject.service.AccountService;
    import main.ewalletSystem.ewalletSystemProject.service.AccountValidationService;
    import main.ewalletSystem.ewalletSystemProject.service.HistoryService;

    import java.util.Optional;
    import java.util.Scanner;

    public class AccountServiceImpl implements AccountService {
        private EWalletSystem eWalletSystem;
        private HistoryService historyService;
        private AccountValidationService accountValidationService = new AccountValidationServiceImpl();

        public AccountServiceImpl(EWalletSystem eWalletSystem,
                                  HistoryService historyService) {
            this.eWalletSystem = eWalletSystem;
            this.historyService = historyService;
        }

        public EWalletSystem geteWalletSystem() {
            return eWalletSystem;
        }

        /**
         * create new account
         * @param account
         * @return ture if account success - false if account already exist
         */
        @Override
        public boolean createAccount(Account account) {
            Optional<Account> optionalAccountByUserName = getOptionalAccountByUserName(account);
            Optional<Account> optioanlAccountByPhoneNumber = getOptionalAccountByPhoneNumber(account);
            if (optionalAccountByUserName.isPresent() || optioanlAccountByPhoneNumber.isPresent()) {
                historyService.addHistory(account.getUserName(), new History("signup", false));
                return false;
            }
            eWalletSystem.getAccounts().add(account);
            historyService.addHistory(account.getUserName(), new History("signup", true));
            return true;
        }

        /**
         * get Account
         * @param account
         * @return
         */
        @Override
        public boolean getAccountByUserNameAndPassword(Account account) {
            boolean isLogin = eWalletSystem.getAccounts().stream()
                    .anyMatch(acc -> acc.getUserName().equals(account.getUserName()) &&
                                     acc.getPassword().equals(account.getPassword()));
            if (isLogin){
                historyService.addHistory(account.getUserName(), new History("login", true));

            }else{
                historyService.addHistory(account.getUserName(), new History("login", false));

            }
            return isLogin;
        }

        @Override
        public Account getAccountByUserName(Account account) {
            Optional<Account> optionalAccount = getOptionalAccountByUserName(account);

            if (optionalAccount.isEmpty()) {
                new AccountNotFoundException("Account not found ");
            }

            return optionalAccount.get();
        }

        /**
         * deposit
         * @param account
         * @param amount
         * @return
         */
        @Override
        public AccountResult deposit(Account account, double amount) {

            Optional<Account> optionalAccount = getOptionalAccountByUserName(account);
            if (optionalAccount.isEmpty()) {
                return new AccountResult(1);
//                throw new AccountNotFoundException("Account not found ");
            }
            if (amount < 100) {
                historyService.addHistory(account.getUserName(), new History("deposit", false));
                  return new AccountResult(2);
//                throw new InvalidAmountException("Amount must be >=100");
            }
            Account accountToDeposit = optionalAccount.get();
            accountToDeposit.setBalance(accountToDeposit.getBalance() + amount);
            historyService.addHistory(account.getUserName(), new History("deposit", true));
            return new AccountResult(4, accountToDeposit.getBalance());
        }

        @Override
        public AccountResult withdraw(Account account, double amount) {
            Optional<Account> optionalAccount = getOptionalAccountByUserName(account);
            if (optionalAccount.isEmpty()) {
                historyService.addHistory(account.getUserName(), new History("Withdraw", false));
                return new AccountResult(1);
            }
            // validate amount >= 100
            if (amount < 100) {
                historyService.addHistory(account.getUserName(), new History("Withdraw", false));
                return new AccountResult(2);
            }
            Account accountWithDraw = optionalAccount.get();
            if (accountWithDraw.getBalance() < amount) {
                historyService.addHistory(account.getUserName(), new History("Withdraw", false));
                return new AccountResult(3);
            }
            accountWithDraw.setBalance(accountWithDraw.getBalance() - amount);
            return new AccountResult(4,accountWithDraw.getBalance());
        }

        @Override
        public Account transfer(Account accountFrom, Account accountTo, double amount) {

            Optional<Account> optionalAccountFrom = getOptionalAccountByUserName(accountFrom);
            if (optionalAccountFrom.isEmpty()) {
                throw new AccountNotFoundException("Account not found ");
            }
            Optional<Account> optionalAccountTo = getOptionalAccountByUserName(accountTo);
            if (optionalAccountTo.isEmpty()) {
                throw new AccountNotFoundException("Account not found ");
            }
            if (amount < 100){
                historyService.addHistory(accountFrom.getUserName(), new History("transfer", false));
                throw new InvalidAmountException("Amount must be >=100");
            }
            Account accountFromTransfer = optionalAccountFrom.get();
            Account accountToTransfer = optionalAccountTo.get();
            if (accountFromTransfer.getBalance() < amount){
                historyService.addHistory(accountFrom.getUserName(), new History("transfer", false));
                throw new InsufficientBalanceException("Insufficient balance");
            }
            if (accountFromTransfer.getUserName().equals(accountToTransfer.getUserName())){
                historyService.addHistory(accountFrom.getUserName(), new History("transfer", false));
                throw new RuntimeException("Cannot transfer to same account");
            }
            accountFromTransfer.setBalance(accountFromTransfer.getBalance()-amount);
            accountToTransfer.setBalance(accountToTransfer.getBalance() + amount);
            historyService.addHistory(accountFrom.getUserName(), new History("transfer", true));
            return accountToTransfer;
        }

        @Override
        public void changePassword(Account account, String oldPassword) {
            if (!account.getPassword().equals(oldPassword)){
                throw new InvalidPasswordException("old password is not correct");

            }
            System.out.println("pls enter the new password: ");
            Scanner scanner = new Scanner(System.in);
            String newPassword = scanner.next();
            if (!accountValidationService.validatePassword(newPassword)){
                throw new InvalidPasswordException("new password does not meet the password policy requirements ");
            }
            if (oldPassword.equals(newPassword)){
                throw new InvalidPasswordException("New password cannot be the same as old password");
            }
            account.setPassword(newPassword);
            historyService.addHistory(account.getUserName(), new History("change Password", true));
            System.out.println("Password changed successfully");
        }

        /**
         * get Optional Account By UserName
         * @param account
         * @return
         */
        private Optional<Account> getOptionalAccountByUserName(Account account) {
            Optional<Account> optionalAccount = eWalletSystem.getAccounts().stream()
                    .filter(acc -> acc.getUserName().equals(account.getUserName())).findFirst();
            return optionalAccount;
        }

        private Optional<Account> getOptionalAccountByPhoneNumber(Account account){
            return eWalletSystem.getAccounts().stream().filter((acc)->acc.getPhoneNumber().equals(account.getPhoneNumber())).findFirst();
        }
    }
