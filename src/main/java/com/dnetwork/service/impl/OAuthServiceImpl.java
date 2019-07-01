package com.dnetwork.service.impl;

import com.dnetwork.domain.DNetUser;
import com.dnetwork.domain.DNetUserAuthenticationDetail;
import com.dnetwork.domain.DNetUserAuthenticationDetailRepository;
import com.dnetwork.domain.DNetUserRepository;
import com.dnetwork.service.api.OAuthService;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Map;

@Service
@EnableMongoAuditing
public class OAuthServiceImpl implements OAuthService {

    private static final String GOOGLE_USER_TYPE = "GOOGLE";
    private static final String GITHUB_USER_TYPE = "GITHUB";
    private final DNetUserRepository repository;
    private final DNetUserAuthenticationDetailRepository dnetUserAuthenticationDetailRepository;

    public OAuthServiceImpl(DNetUserRepository repository,
                            DNetUserAuthenticationDetailRepository dnetUserAuthenticationDetailRepository) {
        this.repository = repository;
        this.dnetUserAuthenticationDetailRepository = dnetUserAuthenticationDetailRepository;
    }


    @Override
    @Transactional
    public DNetUser registerAsUser(Principal principal) {
        OAuth2Authentication authentication = ((OAuth2Authentication) principal);


        Map<String, Object> authenticationDetails = (Map<String, Object>) authentication.getUserAuthentication().getDetails();
         String userType  = null;

        if(((OAuth2Authentication) principal).getUserAuthentication().isAuthenticated() == true)  {
            if (authenticationDetails.get("email") != null) userType = GOOGLE_USER_TYPE;
            else userType = GITHUB_USER_TYPE;
        }

        DNetUser user = repository.findByEmail((String) authenticationDetails.get("email"));


        return user;

    }
}
