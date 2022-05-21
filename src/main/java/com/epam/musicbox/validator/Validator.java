package com.epam.musicbox.validator;

public interface Validator {

    boolean isValidId(String id);

    boolean isValidLogin(String login);

    boolean isValidPassword(String password);

    boolean isValidEmail(String email);
}

