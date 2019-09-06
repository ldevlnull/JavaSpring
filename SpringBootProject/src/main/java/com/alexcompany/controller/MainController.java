package com.alexcompany.controller;

import com.alexcompany.model.User;
import com.alexcompany.repository.UserRepository;
import com.alexcompany.service.UserService;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

/**
 * Created by User on 15.07.2019.
 */
@Controller
@Validated
public class MainController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private static int total = 3;

    @RequestMapping(value = "/users/{page}/{sort}", method = RequestMethod.GET)
    public String users(@PathVariable @Max(value = 5, message = "max is 5") int page,
                        @PathVariable String sort, Model model){
        List<User> users = userService.findAll(PageRequest.of(page-1, total, Sort.by(sort))).getContent();
        model.addAttribute("users", users);
        return "list";
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password, Model model){
        User user = userService.findByUsername(username).orElse(new User());
        if(user.getPassword().isEmpty())
            return "login";
        if(user.getPassword().equals(String.valueOf(password.hashCode()))){
            model.addAttribute("user", user);
            return "home";
        }
        return "login";
    }

}
