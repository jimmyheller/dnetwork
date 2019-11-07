package com.dnetwork.web.api.v1;

import com.dnetwork.service.api.TokenService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;


@Controller
@Slf4j
public class TokenConroller {

    private final TokenService tokenService;

    public TokenConroller(TokenService tokenService) {
        this.tokenService = tokenService;
    }


}
