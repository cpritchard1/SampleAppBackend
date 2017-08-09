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


    public PUser performUserLookup(String userName) {

        return  userRepo.findUserBy(userName);
    }


    public String performCreateUser(String userName, String gender, String password) {

        if(verifyUserExists(userName)) {
            return "A user with that User Name already exists";
        }
        else {
            PUser user = new PUser(userName, gender, password);
            userRepo.save(user);
            return "User successfully created";
        }
    }


    public String performUpdateUser(String userName, String gender, String password) {

        if(verifyUserExists(userName)) {
            PUser user = userRepo.findUserBy(userName);
            user.setUserName(userName);
            user.setGender(gender);
            user.setPassword(password);

            userRepo.save(user);

            return "User successfully updated";
        }
        else{
            return "User does not exist";
        }

    }


    public String performDeleteUser(String userName) {

        if(verifyUserExists(userName)) {
            PUser user = userRepo.findUserBy(userName);
            userRepo.delete(user);
        }
        return "User successfully deleted";
    }


    public List<PUser> performGetAllUsers() {

        return userRepo.findAll();
    }


    boolean verifyUserExists(String username){

        if(userRepo.findUserBy(username) != null){
            return true;
        }
        else{
            return false;
        }
    }
}
