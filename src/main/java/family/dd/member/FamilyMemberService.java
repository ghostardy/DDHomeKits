package family.dd.member;

public class FamilyMemberService {
    FamilyMember familyMember;

    public String login(){
        String username = "username";
        String password = "password";

        familyMember.login("username", "password");
        return new ServiceResponse().toJson();
    }
}
