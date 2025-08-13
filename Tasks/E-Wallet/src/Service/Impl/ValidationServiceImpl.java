package Service.Impl;

import Service.ValidationService;

public class ValidationServiceImpl implements ValidationService {

    @Override
    public Boolean validateName(String username) {
        if (username.length() < 3 || !Character.isUpperCase(username.charAt(0))) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean validatePassword(String password) {
        boolean upCase=false;
        boolean lowCase=false;
        boolean special=false;
        boolean length=password.length() >= 8;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) {
                upCase = true;
            } else if (Character.isLowerCase(c)) {
                lowCase = true;
            } else if (!Character.isLetterOrDigit(c)) {
                special = true;
            }
        }
        if (upCase&&lowCase&&special&&length){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.length()!=12 || phoneNumber.charAt(0)!='2'|| phoneNumber.charAt(1)!='0') {
            return false;
        }
        return true;
    }
}
