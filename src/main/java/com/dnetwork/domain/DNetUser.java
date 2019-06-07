package com.dnetwork.domain;


import org.springframework.data.annotation.Id;

import java.util.Objects;

public class DNetUser extends Auditable {

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


    public DNetUser(String email, String name, String givenName, String familyName, String picture, String locale, String principal, String userType) {
        this.userName = email;
        this.email = email;
        this.name = name;
        this.givenName = givenName;
        this.familyName = familyName;
        this.picture = picture;
        this.locale = locale;
        this.principal = principal;
        this.userType = userType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DNetUser dNetUser = (DNetUser) o;
        return Objects.equals(id, dNetUser.id) &&
                Objects.equals(userName, dNetUser.userName) &&
                Objects.equals(name, dNetUser.name) &&
                Objects.equals(givenName, dNetUser.givenName) &&
                Objects.equals(familyName, dNetUser.familyName) &&
                Objects.equals(picture, dNetUser.picture) &&
                Objects.equals(locale, dNetUser.locale) &&
                Objects.equals(principal, dNetUser.principal) &&
                Objects.equals(userType, dNetUser.userType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, name, givenName, familyName, picture, locale, principal, userType);
    }

    @Override
    public String toString() {
        return "DNetUser{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", givenName='" + givenName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", picture='" + picture + '\'' +
                ", locale='" + locale + '\'' +
                ", principal='" + principal + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
