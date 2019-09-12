package com.dnetwork.web.api.v1;

import com.dnetwork.service.api.TokenService;
import com.dnetwork.web.object.DNetworkResponse;
import com.dnetwork.web.object.ErrorConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.dnetwork.web.object.DNetworkResponse.GENERAL_EXCEPTION;
import static com.dnetwork.web.object.DNetworkResponse.SUCCESS;

@Controller
@Slf4j
public class TokenConroller {

    private final TokenService tokenService;

    public TokenConroller(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping
    @RequestMapping("/api/v1/token/generate")
    @ResponseBody
    DNetworkResponse tokenGenerator(
            @RequestHeader("userId") String userId,
            @RequestHeader("physicalDeviceAddress") String physicalDeviceAddress){
        log.info("TokenGeneratorConroller#tokenGenerator -> requesting to generate token for authenticated user by userId : {}",userId);
        DNetworkResponse response =new DNetworkResponse();
        String token= tokenService.generateTokenForAuthenticatedUser(userId,physicalDeviceAddress);
        response.setData(token);
        if(token != null) response.setResponseCode(SUCCESS);
        else response.setResponseCode(GENERAL_EXCEPTION);
        return response;
    }

    @GetMapping
    @RequestMapping("/api/v1/token/validateToken")
    @ResponseBody
    DNetworkResponse validateToken(
            @RequestHeader("token") String token ,
            @RequestHeader("physicalDeviceAddress") String physicalDeviceAddress){
        DNetworkResponse response =new DNetworkResponse();
        Integer responseValidateToken= tokenService.validateToken(token,physicalDeviceAddress);
        response.setResponseCode(responseValidateToken);
        if(responseValidateToken == 0 ){
            response.setData(token);
        }
        switch (responseValidateToken){
            case 0 :  response.setMessage(ErrorConstant.SUCCESS_DESC);
                break;
            case 100 :  response.setMessage(ErrorConstant.INVALID_PHYSICAL_DEVICE_ADDRESS_DESC);
                break;
            case 101 :  response.setMessage(ErrorConstant.INVALID_JWT_SIGNATURE_DESC);
                break;
            case 102 :  response.setMessage(ErrorConstant.EXPIRED_JWT_TOKEN_DESC);
                break;
            case 103 :  response.setMessage(ErrorConstant.EXPIRED_JWT_TOKEN_DESC);
                break;
            case 104 :  response.setMessage(ErrorConstant.INVALID_JWT_SIGNATURE_DESC);
                break;
            case 105 :  response.setMessage(ErrorConstant.JWT_CLAIMS_STRING_IS_EMPTY_DESC);
                break;
        }
        return response;
    }
}
