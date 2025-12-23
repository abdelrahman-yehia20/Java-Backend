package main.ewalletSystem.ewalletSystemProject.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EWalletSystem {

    private final String name = "EraaSoft E Wallet System";
    private List<Account> accounts = new ArrayList<>();
    private Map<String, List<History>> histories = new HashMap<>();

    public Map<String, List<History>> getHistories() {
        return histories;
    }

    public void setHistories(Map<String, List<History>> histories) {
        this.histories = histories;
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
