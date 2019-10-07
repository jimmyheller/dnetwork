package com.dnetwork.service.api;

public interface TokenGeneratorService {
   String generateTokenForAuthenticatedUser(String userId);
}
