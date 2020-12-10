package family.dd.DDHomeKits.member.handler;

import family.dd.DDHomeKits.entity.HandleResult;
import family.dd.DDHomeKits.entity.UserInfo;
import family.dd.DDHomeKits.member.FamilyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public abstract class LoginHandler {
    protected LoginHandler next;
    protected LoginHandler setNext(LoginHandler next){
        return this.next = next;
    }
    protected LoginHandler getNext(){
        return next;
    }
    public abstract HandleResult handle(UserInfo user);
}
