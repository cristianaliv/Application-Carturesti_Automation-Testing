package org.automation.constants;

public enum LoginDetails {

    LOGIN_USER("cris.mailtest05@gmail.com", "Carturesti.mailtest05!"),
    INVALID_USER("invalidmail@gmail.com", "123786"),
    EMPTY_USER("", "");


    private final String email;
    private String password;

    LoginDetails(String email, String password) {
        this.email = email;
        this.password = password;
    }

    LoginDetails(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
