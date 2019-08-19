package com.dnetwork.domain;


import org.springframework.data.annotation.CreatedDate;

public class Auditable {

    @CreatedDate
    private String createdDate;

    public String getCreatedDate() {
        return createdDate;
    }




    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void testCommit() {}
}
