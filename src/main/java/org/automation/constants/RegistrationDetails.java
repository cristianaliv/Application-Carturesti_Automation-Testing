package org.automation.constants;

public enum RegistrationDetails {

    REGISTERED_EMAIL("cris.mailtest05@gmail.com", "Carturesti.mailtest05!");


    private final String email;
    private String password;

    RegistrationDetails(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

