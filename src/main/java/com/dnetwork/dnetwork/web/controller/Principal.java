package com.dnetwork.dnetwork.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Principal {

    @GetMapping
    @RequestMapping("/userLogin")
    public @ResponseBody
    java.security.Principal user(java.security.Principal principal) {
        return principal;
    }
}
