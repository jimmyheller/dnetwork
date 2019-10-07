package com.dnetwork.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Repository
public class DNetUserRepositoryImpl implements DNetUserRepository {

    private RedisTemplate<String, Object> redisTemplate;

    private HashOperations hashOperations;


    public DNetUserRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(DNetUser user) {
        hashOperations.put("DNetUser", user.getId(), user);
    }

}
