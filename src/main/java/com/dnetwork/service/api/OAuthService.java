package com.dnetwork.service.api;

import com.dnetwork.domain.DNetUser;

import java.security.Principal;


public interface OAuthService {

    DNetUser registerAsGmailUser(Principal principal);
}
