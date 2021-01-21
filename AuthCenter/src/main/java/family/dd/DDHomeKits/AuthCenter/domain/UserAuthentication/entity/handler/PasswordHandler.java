package family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity.handler;

public abstract class PasswordHandler {
    protected PasswordHandler next = null;
    protected PasswordHandler next(PasswordHandler next){
        return this.next = next;
    }
    public abstract String handle(String source, String...seed) throws Exception;
}
