package com.dnetwork.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@Getter
@Setter
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


}
