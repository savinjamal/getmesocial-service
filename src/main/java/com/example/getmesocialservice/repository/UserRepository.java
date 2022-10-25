package com.example.getmesocialservice.repository;

import com.example.getmesocialservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public User getUser() {
        User user = new User("Kevin", "Canada", 20, "MyPic");
        return user;

    }
}
