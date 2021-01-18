package family.dd.DDHomeKits.AuthCenter.controller;

import com.google.gson.Gson;
import family.dd.DDHomeKits.AuthCenter.dao.UserIdentityPO;
import family.dd.DDHomeKits.AuthCenter.definition.ResponseCode;
import family.dd.DDHomeKits.AuthCenter.domain.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static family.dd.DDHomeKits.AuthCenter.util.CommonUtil.isNull;

@RestController
@Scope("prototype")
public class FamilyMemberController {
    private UserAuthentication userAuthentication;
    private Gson gson = new Gson();

    @Autowired
    public void setUserAuthentication (UserAuthentication userAuthentication) {
        this.userAuthentication = userAuthentication;
    }

    @PostMapping("/login")
    public String login(){
        String username = "username";
        String password = "password";
        try {
            User user = userAuthentication.authenticate(username, password);
            if (isNull(user)){
                return new ServiceResponseDTO(ResponseCode.REQUEST_UNAUTHORIZED, "Authenticate Failed! Invalid username or password", null).toJson();
            }else if (!userAuthentication.isPrepared()) {
                return new ServiceResponseDTO(ResponseCode.REQUEST_FORBIDDEN, "User is not prepared now, please try again later", null).toJson();
            }else if (!userAuthentication.canLogin()) {
                return new ServiceResponseDTO(ResponseCode.REQUEST_UNAUTHORIZED, "Not allowed to log in now, please try again later", null).toJson();
            }else {
                return new ServiceResponseDTO(ResponseCode.SUCCESS, "SUCCESS", user).toJson();
            }
        }catch (Exception e) {
            return new ServiceResponseDTO(ResponseCode.SERVER_ERROR, "Server error, please try again later", null).toJson();
        }

    }
    @GetMapping("/signUp")
    public String signUp(){
        User newUser = new User();
        newUser.setUsername("username");

        try {
            return userAuthentication.signUp(newUser, "password").getUsername();
        }catch (Exception e) {}
        return "Wrong";
    }
}
