package com.dnetwork.web.api.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserConroller {

    @GetMapping
    @RequestMapping("user/test")
    @ResponseBody String test(){
        return "test";
    }
}
