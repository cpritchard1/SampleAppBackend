package com.myapp.MyAppBackend.User;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Assert;
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
        PUser user = userRepo.findUserById(1);

        Assert.assertNotNull(user);
        assertThat(user.getUserName(), is("Cody"));
    }

    @Test
    public void getUserByName_ShouldReturnUserObject() {
        PUser user = userRepo.findUserByName("Cody");

        Assert.assertNotNull(user);
        assertThat(user.getUserName(), is("Cody"));
        assertThat(user.getUserId(), is(1));
    }

}
