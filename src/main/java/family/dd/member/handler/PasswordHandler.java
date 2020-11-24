package family.dd.member.handler;

import family.dd.entity.UserInfo;

public abstract class PasswordHandler {
    protected PasswordHandler next;
    protected PasswordHandler setNext(PasswordHandler next){
        return this.next = next;
    }
    protected PasswordHandler getNext(){
        return next;
    }
    public abstract String handle(String password);
}
