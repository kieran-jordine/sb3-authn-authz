package com.kyzen.authnauthz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("api/v1")
public class HomeController {

    @GetMapping()
    public String home() {
        return "Home";
    }

    @GetMapping("/user")
    public String user(Principal principal) {
        return "User: " + principal.getName();
    }

    @GetMapping("/admin")
    public String admin(Principal principal) {
        return "Admin: " + principal.getName();
    }

}
