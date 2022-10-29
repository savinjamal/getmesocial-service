package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.Photo;
import com.example.getmesocialservice.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/photos")
public class PhotoResource {
    @Autowired
    private PhotoService photoService;

    @PostMapping
    public Photo savePhoto(@RequestBody Photo photo) {
        return photoService.savePhoto(photo);
    }
    @GetMapping
    public List<Photo> getAllPhoto() {
        return photoService.getAllPhoto();
    }
    @GetMapping("/findById")
    public List<Photo> getByPhotoId(@RequestParam(name="photoId") String photoId){
        return photoService.getByPhotoId(photoId);
    }

    @PutMapping
    public Photo updatePhoto(@RequestBody Photo photo){
        return photoService.updatePhoto(photo);
    }

    @DeleteMapping
    public void deletePhoto(@RequestParam(name="photoId") String photoId){
        photoService.deletePhoto(photoId);
    }
}
