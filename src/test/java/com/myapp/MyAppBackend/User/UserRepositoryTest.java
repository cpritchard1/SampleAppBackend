package com.myapp.MyAppBackend.User;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by cpritcha on 8/12/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"spring.jpa.hibernate.ddl-auto="})
@DataJpaTest
@Sql({"/db/all-schema.sql", "/db/all-data.sql"})
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepo userRepo;

    @Test
    public void getUserById_ShouldReturnUserObject() {
        PUser actualUser = userRepo.findUserById(1);
        PUser expectedUser = new PUser("Cody", "M", "Password");
        expectedUser.setUserId(1);

        assertThat(actualUser, is(equalTo(expectedUser)));
    }

    @Test
    public void getUserByName_ShouldReturnUserObject() {
        PUser actualUser = userRepo.findUserByName("Cody");
        PUser expectedUser = new PUser("Cody", "M", "Password");
        expectedUser.setUserId(1);

        assertThat(actualUser, is(equalTo(expectedUser)));
    }

//    @Test
//    public void createNewUser_ShouldPersistNewUserObject() {
//        PUser actualUser = new PUser("Test", "M", "Password");
//        userRepo.save(actualUser);
//        PUser expectedUser = userRepo.findUserByName("Test");
//
//        assertThat(actualUser, is(equalTo(expectedUser)));
//    }
//
//    @Test
//    public void updateUser_ShouldPersistUpdatedUserObject() {
//        PUser actualUser = userRepo.findUserByName("Test");
//        actualUser.setUserName("newTest");
//        userRepo.save(actualUser);
//        PUser expectedUser = userRepo.findUserByName("newTest");
//
//        assertThat(actualUser, is(equalTo(expectedUser)));
//    }

}
