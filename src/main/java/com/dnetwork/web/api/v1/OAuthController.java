package com.dnetwork.web.api.v1;

import com.dnetwork.domain.Users;
import com.dnetwork.service.api.OAuthService;
import com.dnetwork.util.JsonResponse;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@Controller

public class OAuthController {

    private final OAuthService oAuthService;

    public OAuthController(OAuthService oAuthService) {
        this.oAuthService = oAuthService;
    }


    /**
     * this method is responsible for creating an oauth token through the google account.
     *
     * @param principal
     * @return user data from third party controller
     */
    @PostMapping
    @RequestMapping("/api/v1/oauth")
    public @ResponseBody
    Principal authorizeUser(Principal principal) {

        oAuthService.saveUserLoginData(principal);

        return principal;
    }

}
