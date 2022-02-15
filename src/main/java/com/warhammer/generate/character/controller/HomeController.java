package com.warhammer.generate.character.controller;

import com.warhammer.generate.character.model.description.CharactersClass;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/register")
    public String home() {
        return CharactersClass.CRIMINAL.getDescription();
    }

    @RequestMapping("/secret")
    public String secret() {
        return "secret";
    }

    @GetMapping("/loginform")
    public String loginForm() {
        return "login_form";
    }

}
