package main.ewalletSystem.ewalletSystemProject.service;

public interface AdminService {
    void viewAllAccounts();
    void viewAllHistories();
    boolean deleteAccount(String userName);
}
