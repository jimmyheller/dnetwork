package com.dnetwork.web.api.v1;

import com.dnetwork.service.api.RegistrationService;
import com.dnetwork.web.object.DNetworkResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.dnetwork.web.object.DNetworkResponse.GENERAL_EXCEPTION;
import static com.dnetwork.web.object.DNetworkResponse.SUCCESS;

@Controller
public class RegistrationConroller {

    private final RegistrationService registrationService;
    private final Logger logger = LoggerFactory.getLogger(OAuthController.class);

    public RegistrationConroller(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    @RequestMapping("user/registerUserToken")
    @ResponseBody
    DNetworkResponse registerUserToken(@RequestParam String userId){
        DNetworkResponse response =new DNetworkResponse();
        String token= registrationService.registerUserToken(userId);
        response.setData(token);
        if(token != null) response.setResponseCode(SUCCESS);
        else response.setResponseCode(GENERAL_EXCEPTION);
        return response;
    }
}
