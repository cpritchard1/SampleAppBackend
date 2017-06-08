package com.myapp.MyAppBackend.User;

import com.myapp.MyAppBackend.infrastructure.web.response.CommonWebResponse;
import com.myapp.MyAppBackend.infrastructure.web.response.FailureWebResponse;
import com.myapp.MyAppBackend.infrastructure.web.response.SuccessWebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * Created by cpritcha on 6/2/17.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping( path = "/{userName}/findUser", method = RequestMethod.GET  )
    @ResponseBody public CommonWebResponse<String> performUserLookup(@PathVariable(required = true, value = "userName" ) String userName) {

        PUser user = userService.performUserLookup(userName);

        if ( user != null ) {
            return new SuccessWebResponse<>("Successfully found user: " + user.getUserName() );
        }
        else {
            return new FailureWebResponse<>("User " + userName + " does not exist" );
        }
    }

    @RequestMapping( path = "/allUsers", method = RequestMethod.GET )
    @ResponseBody public CommonWebResponse<String> performGetAllUsers() {

        List<PUser> usersList = userService.performGetAllUsers();
        String jsonList = null;

        if ( usersList != null ) {

            try {
                ObjectMapper mapper = new ObjectMapper();
                jsonList = mapper.writeValueAsString(usersList);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        else {
            return new FailureWebResponse<>("Failed to get all users");
        }
        return new SuccessWebResponse<>(jsonList);
    }
}
