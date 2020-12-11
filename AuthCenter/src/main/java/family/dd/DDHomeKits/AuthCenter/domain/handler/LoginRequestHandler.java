package family.dd.DDHomeKits.AuthCenter.domain.handler;

import family.dd.DDHomeKits.AuthCenter.dao.HandleResult;
import family.dd.DDHomeKits.AuthCenter.dao.UserIdentityPO;
import family.dd.DDHomeKits.AuthCenter.dao.UserRepository;

public class LoginRequestHandler extends LoginHandler {
    private UserRepository repository = new UserRepository();
    @Override
    public HandleResult handle(UserIdentityPO familyMember) {
        return next.handle(transField(familyMember));
    }

    UserIdentityPO transField(UserIdentityPO familyMember){
        return familyMember;
    }
}
