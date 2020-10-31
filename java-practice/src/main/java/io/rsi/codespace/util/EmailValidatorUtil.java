package io.rsi.codespace.util;


import org.apache.commons.validator.routines.EmailValidator;

public class EmailValidatorUtil {
    public static void main(String[] args) {
        String email = "Ismael.Diaby@gmail.africa";
        System.out.println(EmailValidator.getInstance().isValid(email));
    }
}
