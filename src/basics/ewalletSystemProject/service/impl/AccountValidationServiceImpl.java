package main.ewalletSystem.ewalletSystemProject.service.impl;

import main.ewalletSystem.ewalletSystemProject.service.AccountValidationService;

public class AccountValidationServiceImpl implements AccountValidationService {
    @Override
    public boolean validateUserName(String userName) {
        if (userName.length() < 3 || !userName.matches("^[A-Z][a-zA-Z0-9_ ]*$")) {
            return false;
        }
        return true;
    }

    @Override
    public boolean validatePassword(String password) {
        if (password.length() < 8 || !password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!.,?]).{8,}$")) {
            return false;
        }
        // TODO upper case , lower case , spec char, digit
        return true;
    }

    @Override
    public boolean validateAge(float age) {
        if (age <18){
            return false;
        }
        return true;
    }

    @Override
    public boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 11 || !phoneNumber.matches("[0-9]*$")){
            return false;
        }
        return true;
    }


}
