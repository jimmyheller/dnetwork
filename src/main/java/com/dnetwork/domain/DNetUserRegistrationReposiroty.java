package com.dnetwork.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DNetUserRegistrationReposiroty extends MongoRepository<DNetUserRegistration , String> {

}
