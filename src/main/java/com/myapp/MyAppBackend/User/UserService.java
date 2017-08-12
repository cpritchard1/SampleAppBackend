package com.myapp.MyAppBackend.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by cpritcha on 6/2/17.
 */

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public PUser performUserLookup(Integer userId) {

        return  userRepo.findUserById(userId);
    }


    public String performCreateUser(String userName, String gender, String password) {

        PUser user = new PUser(userName, gender, password);
        userRepo.save(user);
        return "User successfully created";
    }


    public String performUpdateUser(Integer userId, String userName, String gender, String password) {

        PUser user = userRepo.findUserById(userId);
        user.setUserName(userName);
        user.setGender(gender);
        user.setPassword(password);
        userRepo.save(user);
        return "User successfully updated";
    }


    public String performDeleteUser(Integer userId) {

        PUser user = userRepo.findUserById(userId);
        userRepo.delete(user);
        return "User successfully deleted";
    }


    public List<PUser> performGetAllUsers() {

        return userRepo.findAll();
    }

    public boolean validateUserName(String userName) {

        if(userRepo.findUserByName(userName) != null) {
            return true;
        }
        else {
            return false;
        }
    }
}
