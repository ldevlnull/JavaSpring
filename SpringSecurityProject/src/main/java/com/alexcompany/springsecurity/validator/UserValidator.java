package com.alexcompany.springsecurity.validator;

import com.alexcompany.springsecurity.dto.UserDTO;
import com.alexcompany.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UserValidator implements ConstraintValidator<RegistrationValid, UserDTO> {

    @Autowired
    private UserService userService;

    @Override
    public boolean isValid(UserDTO userDTO, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println(userDTO);
        if(userDTO.getEmail().isEmpty() || userDTO.getUsername().isEmpty()
                || userDTO.getPassword().isEmpty() || userDTO.getRepeatPassword().isEmpty()){
            userDTO.setEmailError(userDTO.getEmail().isEmpty() ? "Email cannot be empty!" : "");
            userDTO.setUsernameError(userDTO.getUsername().isEmpty() ? "Username cannot be empty!" : "");
            userDTO.setPasswordError(userDTO.getPassword().isEmpty() ? "Password cannot be empty!" : "");
            return false;
        }
        if(!userDTO.getRepeatPassword().equals(userDTO.getPassword())){
            userDTO.setRepeatPasswordError("Passwords don't match!");
            return false;
        }
        if (userService.checkIfExists(userDTO.getUsername(), userDTO.getEmail())) {
            userDTO.setAlreadyExistsError("User with such username or email already exists!");
            return false;
        }
        return true;
    }

    @Override
    public void initialize(RegistrationValid constraintAnnotation) {
    }
}
