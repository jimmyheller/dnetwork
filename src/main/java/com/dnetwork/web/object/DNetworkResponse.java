package com.dnetwork.web.object;

public class DNetworkResponse<T> {
    public static final int SUCCESS = 0;
    public static final int GENERAL_EXCEPTION = 500;
    private String message;
    private T data;
    private int responseCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
