package com.dnetwork.util;

public class JsonResponse<T> {

    private String message ;
    private T result;
    private int responseCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public JsonResponse() {
    }

    public JsonResponse(String message, T result, int responseCode) {
        this.message = message;
        this.result = result;
        this.responseCode = responseCode;
    }
}
