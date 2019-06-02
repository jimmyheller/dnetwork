package com.dnetwork.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends MongoRepository<Authorities,String> {
}
