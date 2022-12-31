package com.example.emiconnect.entity;

public class StoryModel {

    private String path;
    private Long idUser;

    public StoryModel() {
    }

    public StoryModel(String path, Long idUser) {
        this.path = path;
        this.idUser = idUser;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
                ", idUser=" + idUser +
                '}';
    }
}
