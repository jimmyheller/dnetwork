package com.dnetwork.web.api.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@RequestMapping("/api/v1/oauth")
public class OAuthController {

    /**
     * this method is responsible for creating an oauth token through the google account.
     *
     * @param principal
     * @return user data from third party controller
     */
    @PostMapping
    public @ResponseBody
    Principal authorizeUser(Principal principal) {
        return principal;
    }


}
