package com.example.emiconnect.entity;


public class PostModel {
    private String path;
    private String status;
    private Long idUser;

    public PostModel() {
    }

    public PostModel(String path, String status, Long idUser) {
        this.path = path;
        this.status = status;
        this.idUser = idUser;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "PostModel{" +
                "path='" + path + '\'' +
                ", status='" + status + '\'' +
                ", idUser=" + idUser +
                '}';
    }
}
