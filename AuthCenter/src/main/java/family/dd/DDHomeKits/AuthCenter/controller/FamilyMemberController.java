package family.dd.DDHomeKits.AuthCenter.controller;

import family.dd.DDHomeKits.AuthCenter.dao.UserIdentityPO;
import family.dd.DDHomeKits.AuthCenter.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
public class FamilyMemberController {

    private User user;
    @Autowired
    public void setUser(User user) {
        this.user = user;
    }

    @GetMapping("/login")
    public String login(){
        return user.authenticate("username", "password").getMessage();
    }
    @GetMapping("/signUp")
    public String signUp(){
        UserIdentityPO userIdentityPO = new UserIdentityPO();
        userIdentityPO.setUsername("username");
        userIdentityPO.setPassword("password");

        return user.singUp(userIdentityPO).getMessage();
    }
}
