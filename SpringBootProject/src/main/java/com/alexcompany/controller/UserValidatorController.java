package com.alexcompany.controller;

import com.alexcompany.model.User;
import com.alexcompany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;


/**
 * Created by User on 17.07.2019.
 */
@Controller
public class UserValidatorController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String loadFormPage(Model m){
        m.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/addValidatedUser")
    public String submitForm(@Valid User user, BindingResult result, Model model){
        try{
            if(result.hasErrors()){
                return "registration";
            }
            user.setPassword(String.valueOf(user.getPassword().hashCode()));
            userService.save(user);
            model.addAttribute("message", "Successfully saved new User: "+user.toString());
            model.addAttribute("user", user);
        } catch (Exception e){
            System.out.println(e.getMessage());
            result.addError(new FieldError("User", "email", "This email is already registered!"));
            return "registration";
        }
        return "home";
    }
}
