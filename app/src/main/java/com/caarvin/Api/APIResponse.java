package com.caarvin.Api;

public class APIResponse<T> {


    private String status;
    private String messsage;
    private String userId;



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return messsage;
    }

    public void setMessage(String messsage) {
        this.messsage = messsage;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}