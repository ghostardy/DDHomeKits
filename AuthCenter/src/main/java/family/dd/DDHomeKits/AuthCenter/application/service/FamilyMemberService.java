package family.dd.DDHomeKits.AuthCenter.application.service;

import com.google.gson.Gson;
import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity.ResponseCode;
import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.ServiceResponseDTO;
import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity.User;
import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.UserAuthentication;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static family.dd.DDHomeKits.AuthCenter.infrastructure.util.CommonUtil.isNull;

@RestController
@Scope("prototype")
public class FamilyMemberService {
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
                resp.setData(user);
            }
        }catch (Exception e) {
            resp.setCode(ResponseCode.SERVER_ERROR);
            resp.setMessage("Server error, please try again later");
        }
        return resp.toJson();
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
