package com.ufpb.GestorRepositorios.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tbPhoto")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "photo_id")
    private Long photoId;

    @Column(name = "url")
    private String url;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public Photo(Long photoId, String url, User user) {
        this.photoId = photoId;
        this.url = url;
        this.user = user;
    }

    public Photo() {
    }

    public Long getPhotoId() {
        return photoId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
