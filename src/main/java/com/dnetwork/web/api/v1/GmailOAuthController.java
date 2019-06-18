package com.dnetwork.web.api.v1;


import com.dnetwork.domain.DNetUser;
import com.dnetwork.service.api.OAuthService;
import com.dnetwork.web.object.DNetworkResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.dnetwork.web.object.DNetworkResponse.GENERAL_EXCEPTION;
import static com.dnetwork.web.object.DNetworkResponse.SUCCESS;

@Controller
public class GmailOAuthController {

    private final OAuthService oAuthService;
    private final Logger logger = LoggerFactory.getLogger(GmailOAuthController.class);

    public GmailOAuthController(OAuthService oAuthService) {
        this.oAuthService = oAuthService;
    }


    @GetMapping
    @RequestMapping({ "/api/v1/oauth"})
    public @ResponseBody
    Map<String, String> user(Principal principal) {
        DNetworkResponse<DNetUser> response = new DNetworkResponse<>();
        try {
            logger.info("OAuthController#RegisterUser -> requesting to register the user with {}", principal);
            DNetUser user = oAuthService.registerAsGmailUser(principal);
            response.setData(user);
            response.setResponseCode(SUCCESS);
        } catch (Exception q) {
            logger.error("OAuthController#RegisterUser -> unhandled error in registering the user.");
            response.setResponseCode(GENERAL_EXCEPTION);
            response.setMessage("there was a unhandled error in oAuth platform.");
        }




        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", principal.getName());
        return map;
    }


}
