package com.myapp.MyAppBackend.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cpritcha on 6/2/17.
 */

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public PUser performUserLookup(String userName) {
        PUser user = null;
        try {
            user = userRepo.findUserBy(userName);
        }
        catch (Exception e) {
            String msg = String.format(e.getMessage());
        }
        return user;

    }

    public List<PUser> performGetAllUsers() {

        List<PUser> usersList = new ArrayList<>();
        try {
            usersList = userRepo.findAll();
        }
        catch (Exception e) {
            String msg = String.format(e.getMessage());
        }
        return usersList;
    }
}
