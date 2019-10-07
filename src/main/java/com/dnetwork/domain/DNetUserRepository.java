package com.dnetwork.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;


public interface DNetUserRepository  {

    void save(DNetUser user);

//    DNetUser findByEmail(String email);
//    DNetUser findById(String id);
}
