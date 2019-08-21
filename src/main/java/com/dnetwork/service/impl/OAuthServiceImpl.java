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

    private static final String GMAIL_USER_TYPE = "GMAIL";

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
        DNetUser user = null;
        OAuth2Authentication authentication = ((OAuth2Authentication) principal);


        Map<String, Object> authenticationDetails = (Map<String, Object>) authentication.getUserAuthentication().getDetails();


        if(((OAuth2Authentication) principal).getUserAuthentication().isAuthenticated() == true) {
            user = repository.findByEmail((String) authenticationDetails.get("email"));
            if (user == null) {
                user = new DNetUser((String) authenticationDetails.get("email"),
                        (String) authenticationDetails.get("name"),
                        (String) authenticationDetails.get("given_name"),
                        (String) authenticationDetails.get("family_name"),
                        (String) authenticationDetails.get("picture"),
                        (String) authenticationDetails.get("locale"),
                        principal.getName(),
                        GMAIL_USER_TYPE);

                repository.save(user);
            }

            OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
            DNetUserAuthenticationDetail detail = new DNetUserAuthenticationDetail(
                    details.getRemoteAddress(),
                    details.getSessionId(),
                    details.getTokenType(),
                    details.getTokenValue(), user.getId());
            dnetUserAuthenticationDetailRepository.save(detail);

        }
        return user;
    }
}