package com.dnetwork.service.impl;

import com.dnetwork.domain.DNetUserAuthenticationDetailRepository;
import com.dnetwork.domain.DNetUserRepository;
import com.dnetwork.service.api.OAuthService;
import com.dnetwork.util.redis.RedisUtil;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.security.Principal;

@Service
//@EnableMongoAuditing
public class OAuthServiceImpl implements OAuthService {

    private static final String GMAIL_USER_TYPE = "GMAIL";

    private final DNetUserRepository dNetUserRepository;
    private final DNetUserAuthenticationDetailRepository dNetUserAuthenticationDetailRepository;
    private final RedisUtil redisUtil;


    public OAuthServiceImpl(DNetUserRepository dNetUserRepository
            , DNetUserAuthenticationDetailRepository dNetUserAuthenticationDetailRepository,
                            RedisUtil redisUtil) {
        this.dNetUserRepository = dNetUserRepository;
        this.dNetUserAuthenticationDetailRepository = dNetUserAuthenticationDetailRepository;
        this.redisUtil = redisUtil;
    }

    @Override
    @Transactional
    public String registerAsUser(Principal principal) throws IOException {
        if (((OAuth2Authentication) principal).getUserAuthentication().isAuthenticated()) {
            String principalJson = new ObjectMapper().writeValueAsString(principal);
            redisUtil.save(principal.getName(), principalJson);
            return principalJson;
        }
        return "";
    }

}