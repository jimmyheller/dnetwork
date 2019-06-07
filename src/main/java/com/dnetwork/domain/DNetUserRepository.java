package com.dnetwork.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DNetUserRepository extends MongoRepository<DNetUser, Integer> {

    DNetUser findByEmail(String email);
}
