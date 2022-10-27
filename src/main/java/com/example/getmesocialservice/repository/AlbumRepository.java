package com.example.getmesocialservice.repository;

import com.example.getmesocialservice.model.Album;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlbumRepository {

    public List<Album> getAllAlbums;
    List<Album> albumList = new ArrayList();
    public Album getAlbum(){
        Album album = new Album( "Cool Album","I am Cool", "This is my cool Link");
        return album;
    }

    public Album saveAlbum(Album album) {
        album.setAlbumId(albumList.size() + 1);
        albumList.add(album);
        return album;
    }

    public List<Album> getAllAlbums(){
        return albumList;
    }

    public Album getAlbumById(int albumId) {
        for(Album album:albumList){
            if(album.getAlbumId() == albumId){
                return album;
            }
        }
        return null;
    }

    public Album updateAlbum(int albumId, Album album) {
        for (Album a:albumList){
            if(a.getAlbumId() == albumId){
                a.setName(album.getName());
                a.setDescription(album.getDescription());
                a.setCoverPicUrl(album.getCoverPicUrl());
                return a;
            }
        }
        return null;
    }

    public Album deleteAlbum(int albumId) {
        Album deletedAlbum = null;
        for(Album album : albumList){
            if(album.getAlbumId() == albumId){
                deletedAlbum = album;
                albumList.remove(album);
                return deletedAlbum;
            }
        }
        return deletedAlbum;
    }
}
