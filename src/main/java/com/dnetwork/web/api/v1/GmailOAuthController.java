package com.dnetwork.web.api.v1;


import com.dnetwork.domain.DNetUser;
import com.dnetwork.service.api.OAuthService;
import com.dnetwork.web.DNetworkResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

import static com.dnetwork.web.DNetworkResponse.GENERAL_EXCEPTION;
import static com.dnetwork.web.DNetworkResponse.SUCCESS;

@Controller
@RequestMapping("/api/v1/oauth/gmail")
public class GmailOAuthController {

    private final OAuthService oAuthService;
    private final Logger logger = LoggerFactory.getLogger(GmailOAuthController.class);

    public GmailOAuthController(OAuthService oAuthService) {
        this.oAuthService = oAuthService;
    }


    @GetMapping
    public @ResponseBody
    DNetworkResponse<DNetUser> RegisterUser(Principal principal) {
        DNetworkResponse<DNetUser> response = new DNetworkResponse<>();
        try {
            logger.info("GmailOAuthController#RegisterUser -> requesting to register the user with {}", principal);
            DNetUser user = oAuthService.registerAsGmailUser(principal);
            response.setData(user);
            response.setResponseCode(SUCCESS);
        } catch (Exception q) {
            logger.error("GmailOAuthController#RegisterUser -> unhandled error in registering the user.");
            response.setResponseCode(GENERAL_EXCEPTION);
        }

        return response;
    }

}
