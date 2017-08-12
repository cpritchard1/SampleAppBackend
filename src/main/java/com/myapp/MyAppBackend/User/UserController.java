package com.myapp.MyAppBackend.User;

import com.myapp.MyAppBackend.infrastructure.web.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by cpritcha on 6/2/17.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping( path = "/{userId}/findUser", method = RequestMethod.GET  )
    @ResponseBody public CommonWebResponse<PUser> performUserLookup(@PathVariable(required = true, value = "userId" ) Integer userId) {

        try{
            return new SuccessWebResponse<>(userService.performUserLookup(userId));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            ResponseMessage responseMessage = new ErrorResponseMessage(e.getMessage());
            return new FailureWebResponse<>(null, responseMessage);
        }
    }

    @RequestMapping ( path = "/{userName}/{gender}/{password}/createUser", method = RequestMethod.GET )
    @ResponseBody public CommonWebResponse<String> performCreateUser(
            @PathVariable(required = true, value = "userName") String userName,
            @PathVariable(required = true, value = "gender") String gender,
            @PathVariable(required = true, value = "password") String password) {

        try{
            return new SuccessWebResponse<>(userService.performCreateUser(userName, gender, password));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            ResponseMessage responseMessage = new ErrorResponseMessage(e.getMessage());
            return new FailureWebResponse<>(null, responseMessage);
        }
    }

    @RequestMapping ( path = "/{userId}/{userName}/{gender}/{password}/updateUser", method = RequestMethod.GET )
    @ResponseBody public CommonWebResponse<String> performUpdateUser(
            @PathVariable(required = true, value = "userId") Integer userId,
            @PathVariable(required = true, value = "userName") String userName,
            @PathVariable(required = true, value = "gender") String gender,
            @PathVariable(required = true, value = "password") String password) {

        try{
            return new SuccessWebResponse<>(userService.performUpdateUser( userId, userName, gender, password));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            ResponseMessage responseMessage = new ErrorResponseMessage(e.getMessage());
            return new FailureWebResponse<>(null, responseMessage);
        }
    }

    @RequestMapping( path = "/{userId}/deleteUser", method = RequestMethod.GET  )
    @ResponseBody public CommonWebResponse<String> performDeleteUser(@PathVariable(required = true, value = "userId" ) Integer userId) {

        try{
            return new SuccessWebResponse<>(userService.performDeleteUser(userId));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            ResponseMessage responseMessage = new ErrorResponseMessage(e.getMessage());
            return new FailureWebResponse<>(null, responseMessage);
        }
    }

    @RequestMapping( path = "/allUsers", method = RequestMethod.GET )
    @ResponseBody public CommonWebResponse<List<PUser>> performGetAllUsers() {

        try{
            return new SuccessWebResponse<>(userService.performGetAllUsers());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            ResponseMessage responseMessage = new ErrorResponseMessage(e.getMessage());
            return new FailureWebResponse<>(null, responseMessage);
        }
    }
}
