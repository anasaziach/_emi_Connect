package com.example.emiconnect.entity;

public class RequestChat { //it's used as model
    private Long idSrc;
    private Long idDest;
    private String message;

    public RequestChat() {
    }

    public RequestChat(Long idSrc, Long idDest, String message) {
        this.idSrc = idSrc;
        this.idDest = idDest;
        this.message = message;
    }

    public Long getIdSrc() {
        return idSrc;
    }

    public void setIdSrc(Long idSrc) {
        this.idSrc = idSrc;
    }

    public Long getIdDest() {
        return idDest;
    }

    public void setIdDest(Long idDest) {
        this.idDest = idDest;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
