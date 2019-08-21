package com.dnetwork.domain;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class DNetUserToken extends Auditable {
    @Id
    private String id;
    private String userId;
    private String token;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DNetUserToken that = (DNetUserToken) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, token);
    }

    public DNetUserToken(String userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
