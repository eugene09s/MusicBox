package com.epam.musicbox.validator.impl;

import com.epam.musicbox.validator.Validator;
import jakarta.inject.Singleton;

import java.util.regex.Pattern;

@Singleton
public class ValidatorImpl implements Validator {
    private static final String ID_REGEX = "^([1-9]{1}[0-9]{0,10})$";
    private static final String LOGIN_REGEX = "^([\\w\\s:.'-]{1,30})$";
    private static final String PASSWORD_REGEX = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=\\S+$).{6,50}$";
    private static final String EMAIL_REGEX =
            "^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$";

    private static final Pattern ID_PATTERN = Pattern.compile(ID_REGEX);
    private static final Pattern LOGIN_PATTERN = Pattern.compile(LOGIN_REGEX);
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    private ValidatorImpl() {
    }

    public boolean isValidId(String id) {
        return ID_PATTERN.matcher(id).matches();
    }

    public boolean isValidLogin(String login) {
        return LOGIN_PATTERN.matcher(login).matches();
    }

    public boolean isValidPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }
}