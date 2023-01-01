package com.example.getmesocialservice.model;

import com.example.getmesocialservice.validation.ValidCreatedBy;
import com.example.getmesocialservice.validation.ValidName;

import javax.validation.constraints.Max;

public class Album {

    String id;
    @Max(value = 10)
    String name;
    String coverPhotoUrl;
    @ValidCreatedBy
    String createdBy;
    String dateCreated;
    String photoId;

    public Album(String name, String coverPhotoUrl, String createdBy, String dateCreated, String photoId) {
        this.name = name;
        this.coverPhotoUrl = coverPhotoUrl;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
        this.photoId = photoId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getCoverPhotoUrl() {
        return coverPhotoUrl;
    }

    public void setCoverPhotoUrl(String coverPhotoUrl) {
        this.coverPhotoUrl = coverPhotoUrl;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
