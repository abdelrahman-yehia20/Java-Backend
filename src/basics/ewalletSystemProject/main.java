package main.ewalletSystem.ewalletSystemProject;

import main.ewalletSystem.ewalletSystemProject.service.ApplicationService;
import main.ewalletSystem.ewalletSystemProject.service.impl.EWalletServiceImpl;

public class main {
    public static void main(String[] args) {
        ApplicationService applicationService = new EWalletServiceImpl();
        applicationService.startApp();


    }

}
