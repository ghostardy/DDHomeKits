package family.dd.DDHomeKits.AuthenticationCenter.domain.handler;

import family.dd.DDHomeKits.AuthenticationCenter.dao.HandleResult;
import family.dd.DDHomeKits.AuthenticationCenter.dao.UserInfo;

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
