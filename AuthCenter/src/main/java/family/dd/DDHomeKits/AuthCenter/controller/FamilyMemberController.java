package family.dd.DDHomeKits.AuthCenter.controller;

import family.dd.DDHomeKits.AuthCenter.dao.UserIdentityPO;
import family.dd.DDHomeKits.AuthCenter.definition.ResponseCode;
import family.dd.DDHomeKits.AuthCenter.domain.Authenticator;
import family.dd.DDHomeKits.AuthCenter.domain.ServiceResponseDTO;
import family.dd.DDHomeKits.AuthCenter.domain.UserManager;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
public class FamilyMemberController {

    private Authenticator authenticator;
    private UserManager userManager;
    @Autowired
    public void setAuthenticator(Authenticator authenticator) {
        this.authenticator = authenticator;
    }
    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    @GetMapping("/login")
    public String login(){
        try {
            return authenticator.authenticate("username", "password").toString();
        }catch (Exception e) {
            return new ServiceResponseDTO(ResponseCode.REQUEST_FAILURE, "Authenticate Failed! Invalid username or password", null).toJson();
        }

    }
    @GetMapping("/signUp")
    public String signUp(){
        UserIdentityPO userIdentityPO = new UserIdentityPO();
        userIdentityPO.setUsername("username");
        userIdentityPO.setPassword("password");

        return userManager.singUp(userIdentityPO).getMessage();
    }
}
