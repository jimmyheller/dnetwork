package com.dnetwork.web.object;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DNetworkResponse<T> {
    public static final int SUCCESS = 0;
    public static final int GENERAL_EXCEPTION = 500;
    private String message;
    private T data;
    private int responseCode;

}
