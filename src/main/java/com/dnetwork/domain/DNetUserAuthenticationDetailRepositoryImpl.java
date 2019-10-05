package com.dnetwork.domain;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DNetUserAuthenticationDetailRepositoryImpl implements DNetUserAuthenticationDetailRepository{
    private RedisTemplate<String, Object> redisTemplate;

    private HashOperations hashOperations;


    public DNetUserAuthenticationDetailRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(DNetUserAuthenticationDetail dNetUserAuthenticationDetail) {
        hashOperations.put("DNetUserAuthenticationDetail", dNetUserAuthenticationDetail.getId(), dNetUserAuthenticationDetail);
    }
}
