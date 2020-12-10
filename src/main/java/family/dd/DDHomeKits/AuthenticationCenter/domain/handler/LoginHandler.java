package family.dd.DDHomeKits.AuthenticationCenter.domain.handler;

import family.dd.DDHomeKits.AuthenticationCenter.dao.HandleResult;
import family.dd.DDHomeKits.AuthenticationCenter.dao.UserInfo;

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
