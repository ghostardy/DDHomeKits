package family.dd.DDHomeKits.AuthCenter.domain.handler;

import family.dd.DDHomeKits.AuthCenter.dao.HandleResult;
import family.dd.DDHomeKits.AuthCenter.dao.IdentificationPO;
import family.dd.DDHomeKits.AuthCenter.dao.FamilyMemberRepository;

public class LoginRequestHandler extends LoginHandler {
    private FamilyMemberRepository repository = new FamilyMemberRepository();
    @Override
    public HandleResult handle(IdentificationPO familyMember) {
        return next.handle(transField(familyMember));
    }

    IdentificationPO transField(IdentificationPO familyMember){
        return familyMember;
    }
}
