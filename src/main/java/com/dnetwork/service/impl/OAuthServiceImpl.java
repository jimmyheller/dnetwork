package com.dnetwork.service.impl;

import com.dnetwork.domain.DNetUser;
import com.dnetwork.domain.DNetUserAuthenticationDetail;
import com.dnetwork.domain.DNetUserAuthenticationDetailRepository;
import com.dnetwork.domain.DNetUserRepository;
import com.dnetwork.service.api.OAuthService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Map;

@Service
//@EnableMongoAuditing
public class OAuthServiceImpl implements OAuthService {

    private static final String GMAIL_USER_TYPE = "GMAIL";

    private final DNetUserRepository dNetUserRepository;
    private final DNetUserAuthenticationDetailRepository dNetUserAuthenticationDetailRepository;


    public OAuthServiceImpl(DNetUserRepository dNetUserRepository
            , DNetUserAuthenticationDetailRepository dNetUserAuthenticationDetailRepository
    ) {
        this.dNetUserRepository = dNetUserRepository;
        this.dNetUserAuthenticationDetailRepository = dNetUserAuthenticationDetailRepository;
    }

    @Override
    @Transactional
    public DNetUser registerAsUser(Principal principal) {
        DNetUser user = null;
        OAuth2Authentication authentication = ((OAuth2Authentication) principal);


        Map<String, Object> authenticationDetails = (Map<String, Object>) authentication.getUserAuthentication().getDetails();


        if(((OAuth2Authentication) principal).getUserAuthentication().isAuthenticated() == true) {
//            user = repository.findByEmail((String) authenticationDetails.get("email"));
            if (user == null) {

                user = new DNetUser(
                        principal.getName(),
                        (String) authenticationDetails.get("email"),
                        (String) authenticationDetails.get("name"),
                        (String) authenticationDetails.get("given_name"),
                        (String) authenticationDetails.get("family_name"),
                        (String) authenticationDetails.get("picture"),
                        (String) authenticationDetails.get("locale"),
                        principal.getName(),
                        GMAIL_USER_TYPE,
                        Math.random());
                dNetUserRepository.save(user);

            }

            OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
            DNetUserAuthenticationDetail detail = new DNetUserAuthenticationDetail(
                    user.getId()+details.getSessionId(),
                    details.getRemoteAddress(),
                    details.getSessionId(),
                    details.getTokenType(),
                    details.getTokenValue(),
                    user.getId());
            dNetUserAuthenticationDetailRepository.save(detail);

        }
        return user;
    }

}