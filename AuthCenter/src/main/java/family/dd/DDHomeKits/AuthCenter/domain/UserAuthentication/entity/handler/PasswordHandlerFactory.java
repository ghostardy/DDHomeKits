package family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity.handler;

public class PasswordHandlerFactory {
    public static PasswordHandler getInstance(){
        PasswordHandler step1 = new PasswordSimpleSaltHandler();
        PasswordHandler step2 = new PasswordSHA256Handler();
        PasswordHandler step3 = new PasswordSimpleSaltHandler();
        PasswordHandler step4 = new PasswordSHA256Handler();

        step1.next(step2).next(step3).next(step4);
        return step1;
    }
}
