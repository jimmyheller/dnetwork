package com.dnetwork.service.api;

import java.io.IOException;
import java.security.Principal;


public interface OAuthService {

    String registerAsUser(Principal principal) throws IOException;
}
