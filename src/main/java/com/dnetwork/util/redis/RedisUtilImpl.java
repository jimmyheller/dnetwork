package com.dnetwork.util.redis;

import com.dnetwork.domain.DNetUser;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtilImpl implements RedisUtil {

    private RedisTemplate<String, Object> redisTemplate;

    private HashOperations hashOperations;


    public RedisUtilImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(String key, String value) {
        hashOperations.put("USER_SEGMENT", key, value);
    }
}
