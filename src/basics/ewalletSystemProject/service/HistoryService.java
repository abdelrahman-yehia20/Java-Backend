package main.ewalletSystem.ewalletSystemProject.service;

import main.ewalletSystem.ewalletSystemProject.model.History;

import java.util.List;

public interface HistoryService {
    public void addHistory(String user, History history);
    public List<History> getHistory(String user);
}
