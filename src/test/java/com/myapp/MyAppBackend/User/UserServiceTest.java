package com.myapp.MyAppBackend.User;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
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
public class UserServiceTest {

//    private UserService userService;
//
//    @Autowired
//    private UserRepo userRepo;
//
//    @Before
//    public void setUp() {
//        userService = new UserService();
//        userService.setUserRepo(userRepo);
//    }
//
//    @Test
//    public void findAll_ShouldReturnUserList() {
//        List<PUser> userList = userService.performUserLookup(null, null, null);
//
//        assertThat(userList.size(), is(6));
//    }
//
//    @Test
//    public void findOne_ShouldReturnOneUser() {
//        List<PUser> userList = userService.performUserLookup(null, "Cody", null);
//
//        assertThat(userList.size(), is(1));
//        assertThat(userList.get(0).getUserName(), is("Cody"));
//    }
//
//    @Test
//    public void findGender_ShouldReturnUserList() {
//        List<PUser> userList = userService.performUserLookup( null, null, "F");
//
//        assertThat(userList.size(), is(2));
//        assertThat(userList.get(0).getUserName(), is("Maria"));
//        assertThat(userList.get(1).getUserName(), is("Lauren"));
//    }
//
//    @Test
//    public void createUser_ShouldReturnUser() {
//        Assert.assertTrue(userService.performUserLookup(null, "cpritcha", null).isEmpty());
//
//        PUser actualUser = userService.performCreateUser("cpritcha", "M", "password");
//
//        Assert.assertFalse(userService.performUserLookup(null, "cpritcha", null).isEmpty());
//    }
//
//    @Test
//    public void updateUser_ShouldReturnUpdatedUser() {
//        List<PUser> user = userService.performUserLookup(null, "Cody", null);
//
//        assertThat(user.size(), is(1));
//        assertThat(user.get(0).getGender(), is("M"));
//        assertThat(user.get(0).getPassword(), is("Password"));
//
//        PUser updatedUser = userService.performUpdateUser(1, "cpritcha", "F", "newPassword");
//
//        assertThat(updatedUser.getUserName(), is("cpritcha"));
//        assertThat(updatedUser.getGender(), is("F"));
//        assertThat(updatedUser.getPassword(), is("newPassword"));
//    }
//
//    @Test
//    public void deleteUser_UserShouldNotExist() {
//        Assert.assertNotNull(userRepo.findUserById(1));
//
//        String result = userService.performDeleteUser(1);
//
//        assertThat(result, is("User Successfully Deleted"));
//        Assert.assertNull(userRepo.findUserById(1));
//    }

}
