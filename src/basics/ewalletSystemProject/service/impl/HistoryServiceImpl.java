package main.ewalletSystem.ewalletSystemProject.service.impl;

import main.ewalletSystem.ewalletSystemProject.model.EWalletSystem;
import main.ewalletSystem.ewalletSystemProject.model.History;
import main.ewalletSystem.ewalletSystemProject.service.HistoryService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistoryServiceImpl implements HistoryService {
    private EWalletSystem eWalletSystem;
    public HistoryServiceImpl(EWalletSystem eWalletSystem) {
        this.eWalletSystem = eWalletSystem;
    }
    @Override
    public void addHistory(String user, History history) {
            eWalletSystem.getHistories().computeIfAbsent(user, k->new ArrayList<>()).add(history);
    }

    @Override
    public List<History> getHistory(String user) {
        return eWalletSystem.getHistories().getOrDefault(user, Collections.emptyList());
    }
}
