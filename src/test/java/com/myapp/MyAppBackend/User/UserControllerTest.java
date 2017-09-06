package com.myapp.MyAppBackend.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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

//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private UserService userService;
//
//    @Before
//    public void setUp() {
//        PUser mockUser1 = new PUser( "cpritcha", "M", "password");
//        PUser mockUser2 = new PUser( "username", "M", "password");
//
//        given(userService.performUserLookup(null, null, null))
//                .willReturn(Arrays.asList(mockUser1, mockUser2));
//
//        given(userService.performUserLookup(null, "cpritcha", null))
//                .willReturn(Arrays.asList(mockUser1));
//
//        given(userService.performCreateUser(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
//                .willReturn(mockUser1);
//
//        given(userService.performUpdateUser(Mockito.anyInt(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
//                .willReturn(mockUser1);
//
//        given(userService.performDeleteUser(Mockito.anyInt()))
//                .willReturn(new String("User Successfully Deleted"));
//    }
//
//    @Test
//    public void getAllUsers_ShouldReturnMultipleUsers() throws Exception {
//        mvc.perform(get("/user/findUsers"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.success", is(true)))
//                .andExpect(jsonPath("$.msg", hasSize(0)))
//                .andExpect(jsonPath("$.data", hasSize(2)))
//                .andExpect(jsonPath("$.data[0].userName", is("cpritcha")))
//                .andExpect(jsonPath("$.data[1].userName", is("username")));
//    }
//
//    @Test
//    public void getOneUser_ShouldReturnOneUser() throws Exception {
//        mvc.perform(get("/user/findUsers?userName=cpritcha"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.success", is(true)))
//                .andExpect(jsonPath("$.msg", hasSize(0)))
//                .andExpect(jsonPath("$.data", hasSize(1)))
//                .andExpect(jsonPath("$.data[0].userName", is("cpritcha")));
//    }
//
//    @Test
//    public void createUser_ShouldReturnUser() throws Exception {
//        mvc.perform(post("/user/createUser?userName=cpritcha&gender=M&password=password"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.success", is(true)))
//                .andExpect(jsonPath("$.msg", hasSize(1)))
//                .andExpect(jsonPath("$.msg[0].message", is("User Successfully Created")))
//                .andExpect(jsonPath("$.data.userName", is("cpritcha")));
//    }
//
//    @Test
//    public void updateUser_ShouldReturnUser() throws Exception {
//        mvc.perform(put("/user/updateUser?userId=1&userName=cpritcha&gender=M&password=password"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.success", is(true)))
//                .andExpect(jsonPath("$.msg", hasSize(1)))
//                .andExpect(jsonPath("$.msg[0].message", is("User Successfully Updated")))
//                .andExpect(jsonPath("$.data.userName", is("cpritcha")));
//    }
//
//    @Test
//    public void deleteUser_ShouldReturnSuccessMessage() throws Exception {
//        mvc.perform(delete("/user/1/deleteUser"))
//                .andExpect(jsonPath("$.success", is(true)))
//                .andExpect(jsonPath("$.msg", hasSize(1)))
//                .andExpect(jsonPath("$.msg[0].message", is("User Successfully Deleted")));
//    }
}
