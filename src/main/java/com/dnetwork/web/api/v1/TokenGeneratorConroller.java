package com.dnetwork.web.api.v1;

import com.dnetwork.service.api.TokenGeneratorService;
import com.dnetwork.web.object.DNetworkResponse;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class TokenGeneratorConroller {

    private final TokenGeneratorService tokenGeneratorService;

    public TokenGeneratorConroller(TokenGeneratorService tokenGeneratorService) {
        this.tokenGeneratorService = tokenGeneratorService;
    }

    @GetMapping
    @RequestMapping("/api/v1/token/generate")
    @ResponseBody
    DNetworkResponse tokenGenerator(@RequestParam String userId){
        log.info("TokenGeneratorConroller#tokenGenerator -> requesting to generate token for authenticated user by userId : {}",userId);
        DNetworkResponse response =new DNetworkResponse();
        String token= tokenGeneratorService.generateTokenForAuthenticatedUser(userId);
        response.setData(token);
        if(token != null) response.setResponseCode(SUCCESS);
        else response.setResponseCode(GENERAL_EXCEPTION);
        return response;
    }
}
