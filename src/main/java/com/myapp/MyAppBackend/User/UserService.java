package com.myapp.MyAppBackend.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.data.domain.Example;

/**
 * Created by cpritcha on 6/2/17.
 */

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


/* ***********************************************************************************
        Search for all Users matching the created example
 *************************************************************************************/
    public List<PUser> performUserLookup(Integer userId, String userName, String gender) {

        Example<PUser> example = Example.of(new PUser(userName, gender, null));

        List<PUser> users = userRepo.findAll(example);

        return users;
    }


/* ***********************************************************************************
        Create Update or Delete a User object and return true on success
 *************************************************************************************/
    public User performUpdateUser(User user) {

        PUser entity;

        if(user.getSetForDelete()) {
            userRepo.delete(userRepo.findUserById(user.getUserId()));
            return null;
        }
        else if(user.isNew()) {
            entity = new UserToPUserConverter(user).toEntityObject();
            userRepo.save(entity);
        }
        else {
            entity = userRepo.findUserById(user.getUserId()).updateEntity(user);
            userRepo.save(entity);
        }

        return new PUserToUserConverter(entity).toDomainObject();
    }

/* ***********************************************************************************
       Used for setting repository during unit testing
 *************************************************************************************/
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
}
