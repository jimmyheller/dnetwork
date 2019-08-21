package com.dnetwork.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.dnetwork.domain.DNetUser;
import com.dnetwork.domain.DNetUserToken;
import com.dnetwork.domain.DNetUserTokenReposiroty;
import com.dnetwork.domain.DNetUserRepository;
import com.dnetwork.service.api.TokenGeneratorService;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.stereotype.Service;

@Service
@EnableMongoAuditing
public class TokenGeneratorServiceImpl implements TokenGeneratorService {

    private final DNetUserTokenReposiroty dNetUserTokenReposiroty;
    private final DNetUserRepository repository;

    public TokenGeneratorServiceImpl(DNetUserTokenReposiroty dNetUserTokenReposiroty, DNetUserRepository repository) {
        this.dNetUserTokenReposiroty = dNetUserTokenReposiroty;
        this.repository = repository;
    }

    @Override
    public String generateTokenForAuthenticatedUser(String userId) {
        DNetUser user = repository.findById(userId);
        String token = null;
        if (user != null) {
            try {
                Algorithm algorithm = Algorithm.HMAC256("secret");
                token = JWT.create()
                        .withIssuer("auth0")
                        .sign(algorithm);
                DNetUserToken dNetUserToken = new DNetUserToken(userId, token);
                dNetUserTokenReposiroty.save(dNetUserToken);
            } catch (JWTCreationException exception) {
                //Invalid Signing configuration / Couldn't convert Claims.
            }
        }
        return token;
    }
}
