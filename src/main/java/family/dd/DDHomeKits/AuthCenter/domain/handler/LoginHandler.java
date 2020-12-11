package family.dd.DDHomeKits.AuthCenter.domain.handler;

import family.dd.DDHomeKits.AuthCenter.dao.HandleResult;
import family.dd.DDHomeKits.AuthCenter.dao.IdentificationPO;

public abstract class LoginHandler {
    protected LoginHandler next;
    protected LoginHandler setNext(LoginHandler next){
        return this.next = next;
    }
    protected LoginHandler getNext(){
        return next;
    }
    public abstract HandleResult handle(IdentificationPO user);
}
