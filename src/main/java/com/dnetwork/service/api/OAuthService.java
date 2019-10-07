package com.dnetwork.service.api;

import com.dnetwork.domain.DNetUser;

import java.security.Principal;
import java.util.Map;


public interface OAuthService {

    DNetUser registerAsUser(Principal principal);
}
