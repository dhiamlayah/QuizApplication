package com.Ml_Dhia.QuizApp.model;

public class Response {
    private int  id ;
    private String userResponse ;

    public Response(String userResponse, int id) {
        this.userResponse = userResponse;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(String userResponse) {
        this.userResponse = userResponse;
    }
}
