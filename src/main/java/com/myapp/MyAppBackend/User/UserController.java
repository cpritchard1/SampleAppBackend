package com.myapp.MyAppBackend.User;

import com.myapp.MyAppBackend.infrastructure.web.response.*;
import org.apache.commons.lang3.exception.ExceptionUtils;
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

    // .../user/findUsers?userid= &userName= &gender=
    @RequestMapping( path = "/findUsers", method = RequestMethod.GET  )
    @ResponseBody public CommonWebResponse<List<PUser>> performUserLookup(
            @RequestParam(required = false, value = "userId" ) Integer userId,
            @RequestParam(required = false, value = "userName") String userName,
            @RequestParam(required = false, value = "gender")String gender) {

        try {
            List<PUser> users = userService.performUserLookup(userId, userName, gender);

            if(users.isEmpty()){
                ResponseMessage responseMessage = new ErrorResponseMessage("No Users Were Found Matching Search Criteria");
                return new FailureWebResponse<>(null, responseMessage);
            }
            else {
                return new SuccessWebResponse<>(users);
            }
        }
        catch(Exception e){
            System.out.println("********************************");
            System.out.println("Unknown Exception occurred, thrown from UserController/findUsers");
            System.out.println(e.getMessage());
            ResponseMessage responseMessage = new ErrorResponseMessage(ExceptionUtils.getRootCauseMessage(e));
            return new FailureWebResponse<>(null, responseMessage);
        }
    }

    @RequestMapping ( path = "/updateUser", method = RequestMethod.PUT )
    public CommonWebResponse<User> performUpdateUser(
            @RequestBody User user) {

        try{
            ResponseMessage responseMessage = new InfoResponseMessage("User Successfully Updated");
            return new SuccessWebResponse<>(userService.performUpdateUser(user), responseMessage);
        }
        catch(Exception e){
            System.out.println("********************************");
            System.out.println("Unknown Exception occurred, thrown from UserController/updateUser");
            System.out.println(e.getMessage());
            ResponseMessage responseMessage = new ErrorResponseMessage(ExceptionUtils.getRootCauseMessage(e));
            return new FailureWebResponse<>(null, responseMessage);
        }
    }

}
