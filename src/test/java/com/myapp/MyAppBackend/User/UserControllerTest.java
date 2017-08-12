package com.myapp.MyAppBackend.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by cpritcha on 6/2/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(
        controllers = UserController.class
)

@AutoConfigureMockMvc(secure = false)
public class UserControllerTest {

    @Autowired private MockMvc mvc;
    @MockBean private UserService userService;

    @Test
    public void goodURL_shouldReturnSuccess() throws Exception {

        mvc.perform(get("/user/1/findUser").accept(MediaType.ALL))
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$.success"), is(true)));
    }

    @Test
    public void badURL_shouldNotBeFound() throws Exception {

        mvc.perform(get( "/user/findUser").accept(MediaType.ALL))
                .andExpect(status().isNotFound());
    }
}
