package com.dnetwork.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.dnetwork.domain.DNetUser;
import com.dnetwork.domain.DNetUserRegistration;
import com.dnetwork.domain.DNetUserRegistrationReposiroty;
import com.dnetwork.domain.DNetUserRepository;
import com.dnetwork.service.api.RegistrationService;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.stereotype.Service;

@Service
@EnableMongoAuditing
public class RegistrationServiceImpl implements RegistrationService {

    private final DNetUserRegistrationReposiroty dNetUserRegistrationReposiroty;
    private final DNetUserRepository repository;

    public RegistrationServiceImpl(DNetUserRegistrationReposiroty dNetUserRegistrationReposiroty, DNetUserRepository repository) {
        this.dNetUserRegistrationReposiroty = dNetUserRegistrationReposiroty;
        this.repository = repository;
    }

    @Override
    public String registerUserToken(String userId) {
        DNetUser user = repository.findById(userId);
        String token = null;
        if (user != null) {
            try {
                Algorithm algorithm = Algorithm.HMAC256("secret");
                token = JWT.create()
                        .withIssuer("auth0")
                        .sign(algorithm);
                DNetUserRegistration dNetUserRegistration = new DNetUserRegistration(userId, token);
                dNetUserRegistrationReposiroty.save(dNetUserRegistration);
            } catch (JWTCreationException exception) {
                //Invalid Signing configuration / Couldn't convert Claims.
            }
        }
        return token;
    }
}
