//package com.myapp.MyAppBackend.User;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.is;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * Created by cpritcha on 8/12/17.
// */
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(properties = {"spring.jpa.hibernate.ddl-auto="})
//@DataJpaTest
//@Sql({"/db/all-schema.sql", "/db/all-data.sql"})
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
//public class UserServiceTest {
//
//    @Autowired
//    private UserService userService;
//
//    @Test
//    public void createNewUser_ShouldPersistNewUserObject() {
//        String actualString = userService.performCreateUser("Test", "M", "Password");
//        String expectedString = "User successfully created";
//
//        assertThat(actualString, is(equalTo(expectedString)));
//    }
//
//    @Test
//    public void updateUser_ShouldPersistUpdatedUserObject() {
//        String actualString = userService.performUpdateUser(6, "NewTest", "M", "Password");
//        String expectedString = "User successfully updated";
//
//        assertThat(actualString, is(equalTo(expectedString)));
//    }
//
//    @Test
//    public void deleteUser_ShouldReturnSuccessString() {
//        String actualString = userService.performDeleteUser(6);
//        String expectedString = "User successfully deleted";
//
//        assertThat(actualString, is(equalTo(expectedString)));
//    }
//}
