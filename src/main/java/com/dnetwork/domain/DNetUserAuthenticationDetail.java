package com.dnetwork.domain;

import org.springframework.data.annotation.Id;

import java.util.Objects;


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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public String getDnetUserId() {
        return dnetUserId;
    }

    public void setDnetUserId(String dnetUserId) {
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

    @Override
    public String toString() {
        return "DNetUserAuthenticationDetail{" +
                "id='" + id + '\'' +
                ", remoteAddress='" + remoteAddress + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", tokenValue='" + tokenValue + '\'' +
                ", dnetUserId='" + dnetUserId + '\'' +
                '}';
    }
}
