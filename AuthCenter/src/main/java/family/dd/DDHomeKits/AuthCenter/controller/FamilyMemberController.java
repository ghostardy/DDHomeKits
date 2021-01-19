package family.dd.DDHomeKits.AuthCenter.controller;

import com.google.gson.Gson;
import family.dd.DDHomeKits.AuthCenter.dao.UserIdentityPO;
import family.dd.DDHomeKits.AuthCenter.definition.ResponseCode;
import family.dd.DDHomeKits.AuthCenter.domain.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password){
        ServiceResponseDTO resp = new ServiceResponseDTO();
        try {
            User user = userAuthentication.authenticate(username, password);
            if (isNull(user)){
                resp.setCode(ResponseCode.REQUEST_UNAUTHORIZED);
                resp.setMessage("Authenticate Failed! Invalid username or password");
            }else if (!userAuthentication.isPrepared()) {
                resp.setCode(ResponseCode.REQUEST_FORBIDDEN);
                resp.setMessage("User is not prepared now, please try again later");
            }else if (!userAuthentication.canLogin()) {
                resp.setCode(ResponseCode.REQUEST_UNAUTHORIZED);
                resp.setMessage("Not allowed to log in now, please try again later");
            }else {
                resp.setCode(ResponseCode.SUCCESS);
                resp.setMessage("SUCCESS");
                resp.setData(gson.toJson(user));
            }
        }catch (Exception e) {
            resp.setCode(ResponseCode.SERVER_ERROR);
            resp.setMessage("Server error, please try again later");
        }
        return gson.toJson(resp);
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
