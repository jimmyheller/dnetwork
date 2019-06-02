package com.dnetwork.service.api;

import com.dnetwork.domain.Users;

import java.security.Principal;

public interface OAuthService {

    public void saveUserLoginData(Principal principal);

}
