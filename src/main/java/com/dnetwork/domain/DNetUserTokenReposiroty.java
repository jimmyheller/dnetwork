package com.dnetwork.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DNetUserTokenReposiroty extends MongoRepository<DNetUserToken, String> {

}
