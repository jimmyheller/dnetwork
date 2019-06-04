package com.dnetwork.service.impl;

import com.dnetwork.domain.UserRepository;
import com.dnetwork.domain.Users;
import com.dnetwork.service.api.OAuthService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Map;

@Service
public class OAuthServiceImpl implements OAuthService {

    private final UserRepository repository;

    public OAuthServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveUserLoginData(Principal principal) {

        //PrincipalExtract and set into user Entity
        Map<String, Object> details = (Map<String, Object>) ((OAuth2Authentication) principal).getUserAuthentication().getDetails();
        System.out.println(principal.getName()+"   "+details.get("email"));
        Users user = new Users();
        user.setUserName((String) details.get("email"));
        user.setName((String) details.get("name"));
        user.setGiven_name((String)details.get("given_name"));
        user.setFamily_name((String) details.get("family_name"));
        user.setPicture((String) details.get("picture"));
        user.setLocale((String) details.get("locale"));
        user.setPrincipal(principal.getName());

        repository.save(user);

    }
}
