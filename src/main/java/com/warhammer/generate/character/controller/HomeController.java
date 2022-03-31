package com.warhammer.generate.character.controller;

import com.warhammer.generate.character.model.description.Gender;
import com.warhammer.generate.character.model.description.Race;
import com.warhammer.generate.character.model.name.FullName;
import com.warhammer.generate.character.service.NameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class HomeController {

    private final NameService nameService;

    public HomeController(NameService nameService) {
        this.nameService = nameService;
    }

    @GetMapping(path = "/hero")
    public FullName generateHeroDescription(@RequestParam String race, @RequestParam String gender) {
        return nameService.generateName(Race.valueOf(race), Gender.valueOf(gender));
    }
//    @GetMapping("/register")
//    public String home() {
//        return CharactersClass.CRIMINAL.getDescription();
//    }
//
//    @RequestMapping("/secret")
//    public String secret() {
//        return "secret";
//    }
//
//    @GetMapping("/loginform")
//    public String loginForm() {
//        return "login_form";
//    }

}
