package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.exception.RestrictedInfoException;
import com.example.getmesocialservice.model.User;
import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.service.UserService;
import com.example.getmesocialservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserResource {

    @Autowired
    private UserService userService;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public User saveUser(@RequestBody @Valid User user)throws RestrictedInfoException  {
        if(user.getName().equalsIgnoreCase("root")){
            throw new RestrictedInfoException();
        }
        return userService.saveUser(user);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUser();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/findById")
    public List<User> getByUserId(@RequestParam(name="userId") String userId){

        return userService.getByUserId(userId);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateUserProfilePicture")
    public User updateUserProfilePicture(@RequestBody User user){
        return userService.updateUserProfilePicture(user);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping
    public void deleteUser(@RequestParam(name="userId") String userId){
        userService.deleteUser(userId);
    }
}
