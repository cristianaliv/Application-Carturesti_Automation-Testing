package org.automation.constants;

public enum LoginDetails {

    LOGIN_USER("cristiana.livadariu@gmail.com", "PAROLAMEA");


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
