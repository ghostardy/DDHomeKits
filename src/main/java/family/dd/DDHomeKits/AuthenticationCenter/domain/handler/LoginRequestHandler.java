package family.dd.DDHomeKits.AuthenticationCenter.domain.handler;

import family.dd.DDHomeKits.AuthenticationCenter.dao.HandleResult;
import family.dd.DDHomeKits.AuthenticationCenter.dao.UserInfo;
import family.dd.DDHomeKits.AuthenticationCenter.dao.FamilyMemberRepository;

public class LoginRequestHandler extends LoginHandler {
    private FamilyMemberRepository repository = new FamilyMemberRepository();
    @Override
    public HandleResult handle(UserInfo familyMember) {
        return next.handle(transField(familyMember));
    }

    UserInfo transField(UserInfo familyMember){
        return familyMember;
    }
}
