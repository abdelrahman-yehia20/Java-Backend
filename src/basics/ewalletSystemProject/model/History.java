package main.ewalletSystem.ewalletSystemProject.model;

import java.time.LocalDateTime;

public class History {
//    private String userName;
    private LocalDateTime actionTime;
    private String action;
    boolean status;

    public History(String action, boolean status){
        this.action = action;
        this.actionTime = LocalDateTime.now();
        this.status=status;
    }

    public LocalDateTime getActionTime() {
        return actionTime;
    }

    public void setActionTime(LocalDateTime actionTime) {
        this.actionTime = actionTime;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "[" + actionTime + "] " + action + " - " + status + " ";
    }
}
