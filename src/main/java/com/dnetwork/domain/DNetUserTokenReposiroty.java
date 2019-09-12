package com.dnetwork.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DNetUserTokenReposiroty extends MongoRepository<DNetUserToken, String> {
    DNetUserToken findByToken(String token);
    DNetUserToken findByUserId(String userId);
    DNetUserToken findById(String id);

}
