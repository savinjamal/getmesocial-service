package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.model.Photo;
import com.example.getmesocialservice.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/albums")
public class AlbumResource {

    @Autowired
    private AlbumService albumService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public Album saveAlbum(@RequestBody @Valid Album album) {
        return albumService.saveAlbum(album);
    }
    
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Album> getAllAlbum() {
        return albumService.getAllAlbum();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/findById")
    public List<Album> getByAlbumId(@RequestParam(name="albumId") String albumId){
        return albumService.getByAlbumId(albumId);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public Album updateAlbum(@RequestBody Album album){
        return albumService.updateAlbum(album);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping
    public void deleteAlbum(@RequestParam(name="albumId") String albumId){
        albumService.deleteAlbum(albumId);
    }

    /*@GetMapping("/album")
    public Album getAlbum() {
        return albumService.getAlbum();
    }

    @PostMapping("/album")
    public Album saveAlbum(@RequestBody Album album){
        return albumService.saveAlbum(album);
    }

    @GetMapping("/allAlbums")
    public List<Album> getAllAlbums(){
        return albumService.getAllAlbums();
    }

    @GetMapping("/album/{albumId}")
    public Album getAlbumById(@PathVariable("albumId") int albumId){
        return albumService.getAlbumById(albumId);
    }

    @PutMapping("/album/{albumId}")
    public Album updateAlbum(@PathVariable("albumId") int albumId, @RequestBody Album album){
        return albumService.updateAlbum(albumId, album);
    }

    @DeleteMapping("/album")
    public Album deleteAlbum(@RequestParam(name = "albumId") int albumId){
        return albumService.deleteAlbum(albumId);
    }*/
}
