package family.dd.member.handler;

import family.dd.entity.HandleResult;
import family.dd.entity.UserInfo;

public abstract class PasswordHandler {
    protected PasswordHandler next = null;
    protected PasswordHandler setNext(PasswordHandler next){
        return this.next = next;
    }
    protected PasswordHandler getNext(){
        return next;
    }
    public abstract HandleResult handle(UserInfo user);
}
