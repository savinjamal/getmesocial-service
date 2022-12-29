package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.Photo;
import com.example.getmesocialservice.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/photos")
public class PhotoResource {
    @Autowired
    private PhotoService photoService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public Photo savePhoto(@RequestBody @Valid Photo photo) {
        return photoService.savePhoto(photo);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Photo> getAllPhoto() {
        return photoService.getAllPhoto();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/findById")
    public List<Photo> getByPhotoId(@RequestParam(name="photoId") String photoId){
        return photoService.getByPhotoId(photoId);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public Photo updatePhoto(@RequestBody Photo photo){
        return photoService.updatePhoto(photo);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping
    public void deletePhoto(@RequestParam(name="photoId") String photoId){
        photoService.deletePhoto(photoId);
    }
}
