package family.dd.DDHomeKits.AuthCenter.domain.handler;

import family.dd.DDHomeKits.AuthCenter.dao.HandleResult;
import family.dd.DDHomeKits.AuthCenter.dao.IdentificationPO;

public abstract class PasswordHandler {
    protected PasswordHandler next = null;
    protected PasswordHandler setNext(PasswordHandler next){
        return this.next = next;
    }
    protected PasswordHandler getNext(){
        return next;
    }
    public abstract HandleResult handle(IdentificationPO user);
}
