package com.dnetwork.web.api.v1;


import com.dnetwork.domain.DNetUser;
import com.dnetwork.service.api.OAuthService;
import com.dnetwork.web.object.DNetworkResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

import static com.dnetwork.web.object.DNetworkResponse.GENERAL_EXCEPTION;
import static com.dnetwork.web.object.DNetworkResponse.SUCCESS;


@Controller
@Slf4j
public class OAuthController {

    private final OAuthService oAuthService;

    public OAuthController(OAuthService oAuthService) {
        this.oAuthService = oAuthService;
    }

    @GetMapping
    @RequestMapping({"/api/v1/oauth/gmail"})
    public @ResponseBody
    DNetworkResponse<String> registerUser(Principal principal) {
        DNetworkResponse<String> response = new DNetworkResponse<>();
        try {
            log.debug("OAuthController#RegisterUser -> requesting to register the user with {}", principal);
            String user = oAuthService.registerAsUser(principal);
            if (!user.equals("")) {
                response.setData(user);
                response.setResponseCode(SUCCESS);
            } else {
                response.setResponseCode(GENERAL_EXCEPTION);
            }


        } catch (Exception q) {
            log.error("OAuthController#RegisterUser -> unhandled error in registering the user.",q);
            response.setResponseCode(GENERAL_EXCEPTION);
            response.setMessage("there was a unhandled error in oAuth platform.");
        }
        return response;
    }
}
