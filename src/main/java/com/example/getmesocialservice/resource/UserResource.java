package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.User;
import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.service.UserService;
import com.example.getmesocialservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user) {
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

    @DeleteMapping
    public void deleteUser(@RequestParam(name="userId") String userId){
        userService.deleteUser(userId);
    }
}
