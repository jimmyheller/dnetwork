package com.dnetwork.domain;


import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@Getter
@Setter
@ToString
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

}
