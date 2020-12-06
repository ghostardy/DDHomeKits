package family.dd.DDHomeKits.member;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FamilyMemberService {
    FamilyMember familyMember = new FamilyMember();

    @GetMapping("/login")
    public String login(){
        String username = "username";
        String password = "password";

        //familyMember.login("username", "password");
        //return new ServiceResponse().toJson();
        return "Hello";
    }
}
