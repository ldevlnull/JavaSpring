package com.alexcompany.springsecurity.dto;

import com.alexcompany.springsecurity.validator.RegistrationValid;
import org.springframework.validation.annotation.Validated;

@Validated
@RegistrationValid
public class UserDTO {

    private String username;
    private String email;
    private String password;
    private String repeatPassword;

    private String usernameError;
    private String emailError;
    private String passwordError;
    private String repeatPasswordError;
    private String alreadyExistsError;

    public String getRepeatPasswordError() {
        return repeatPasswordError;
    }

    public void setRepeatPasswordError(String repeatPasswordError) {
        this.repeatPasswordError = repeatPasswordError;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getAlreadyExistsError() {
        return alreadyExistsError;
    }

    public void setAlreadyExistsError(String alreadyExistsError) {
        this.alreadyExistsError = alreadyExistsError;
    }

    public UserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", repeatPassword='" + repeatPassword + '\'' +
                '}';
    }
}
