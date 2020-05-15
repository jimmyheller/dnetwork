package com.dnetwork.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;


@Getter
@Setter
public class Auditable {

    @CreatedDate
    private String createdDate;
}
