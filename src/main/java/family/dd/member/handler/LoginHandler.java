package family.dd.member.handler;

import family.dd.entity.HandleResult;
import family.dd.entity.UserInfo;

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
