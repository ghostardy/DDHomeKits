package family.dd.DDHomeKits.AuthCenter.controller;

import family.dd.DDHomeKits.AuthCenter.domain.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FamilyMemberController {
    User user = new User();

    @GetMapping("/login")
    public String login(){
        //UserIdentityPO userInfo = new UserIdentityPO("username", "password");

        //familyMember.login("username", "password");
        //return new ServiceResponse().toJson();
        return "Hello";
    }
}
