package com.example.faturrahman.rumahkita.data.model;

public class Chatroom {
    private String id;
    private String userId;
    private String tukangId;

    public Chatroom() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTukangId() {
        return tukangId;
    }

    public void setTukangId(String tukangId) {
        this.tukangId = tukangId;
    }
}
