package family.dd.DDHomeKits.member;

import family.dd.DDHomeKits.entity.UserInfo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FamilyMemberController {
    FamilyMember familyMember = new FamilyMember();

    @GetMapping("/login")
    public String login(){
        UserInfo userInfo = new UserInfo("username", "password");

        //familyMember.login("username", "password");
        //return new ServiceResponse().toJson();
        return "Hello";
    }
}
