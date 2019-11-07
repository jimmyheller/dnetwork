package com.dnetwork.domain;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@ToString
@Builder
@RedisHash("DNetUser")
public class DNetUser extends Auditable implements Serializable {
    private static long longId = 1;

    @Id
    private String id;
    private String userName;
    private String email;
    private String name;
    private String givenName;
    private String familyName;
    private String picture;
    private String locale;
    private String principal;
    private String userType;
    private double randomNumber;

}
