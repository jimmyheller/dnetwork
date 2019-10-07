package com.dnetwork.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@Getter
@Setter
@ToString
public class DNetUserAuthenticationDetail extends Auditable {
    @Id
    private String id;
    private String remoteAddress;
    private String sessionId;
    private String tokenType;
    private String tokenValue;
    private String dnetUserId;


    public DNetUserAuthenticationDetail(String remoteAddress, String sessionId, String tokenType, String tokenValue, String dnetUserId) {
        this.remoteAddress = remoteAddress;
        this.sessionId = sessionId;
        this.tokenType = tokenType;
        this.tokenValue = tokenValue;
        this.dnetUserId = dnetUserId;
    }

     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DNetUserAuthenticationDetail that = (DNetUserAuthenticationDetail) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(remoteAddress, that.remoteAddress) &&
                Objects.equals(sessionId, that.sessionId) &&
                Objects.equals(tokenType, that.tokenType) &&
                Objects.equals(tokenValue, that.tokenValue) &&
                Objects.equals(dnetUserId, that.dnetUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, remoteAddress, sessionId, tokenType, tokenValue, dnetUserId);
    }

 }
