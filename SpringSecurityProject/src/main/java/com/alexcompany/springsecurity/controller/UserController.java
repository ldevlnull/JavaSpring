package com.alexcompany.springsecurity.controller;

import com.alexcompany.springsecurity.dto.UserDTO;
import com.alexcompany.springsecurity.model.User;
import com.alexcompany.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("userDTO", new UserDTO());
        return "registration";
    }

    @GetMapping("/login")
    public String login(@RequestParam(defaultValue = "false", name = "error") String hasError, Model model) {
        if (Boolean.valueOf(hasError))
            model.addAttribute("message", "Incorrect Username or Password!");
        return "login";
    }


    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute @Valid UserDTO user, BindingResult result, WebRequest webRequest, Errors errors) {
        if(result.hasErrors()){
            return new ModelAndView("registration", "userDTO", user);
        }
        User u = userService.registerNewUser(user);
        return new ModelAndView("login", "user", u);
    }

}
