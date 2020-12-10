package family.dd.DDHomeKits.member.handler;

import family.dd.DDHomeKits.definition.ResponseCode;
import family.dd.DDHomeKits.entity.HandleResult;
import family.dd.DDHomeKits.entity.UserInfo;
import family.dd.DDHomeKits.member.FamilyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

import static family.dd.DDHomeKits.util.CommonUtil.isNull;

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
