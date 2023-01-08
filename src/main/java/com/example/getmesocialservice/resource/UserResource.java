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
    

    @PostMapping
    public User saveUser(@RequestBody @Valid User user)throws RestrictedInfoException  {
        if(user.getName().equalsIgnoreCase("root")){
            throw new RestrictedInfoException();
        }
        return userService.saveUser(user);
    }
    

    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUser();
    }
    

    @GetMapping("/findById")
    public List<User> getByUserId(@RequestParam(name="userId") String userId){

        return userService.getByUserId(userId);
    }
    

    @PutMapping
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @PutMapping("/updateUserProfilePicture")
    public User updateUserProfilePicture(@RequestBody User user){
        return userService.updateUserProfilePicture(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam(name="userId") String userId){
        userService.deleteUser(userId);
    }
}
