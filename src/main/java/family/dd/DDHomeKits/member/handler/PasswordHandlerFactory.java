package family.dd.DDHomeKits.member.handler;

public class PasswordHandlerFactory {
    public static PasswordHandler getInstance(){
        PasswordHandler step1 = new PasswordSimpleSaltHandler();
        PasswordHandler step2 = new PasswordSHA256Handler();
        PasswordHandler step3 = new PasswordSimpleSaltHandler();
        PasswordHandler finalStep = new PasswordSHA256Handler();

        step1.setNext(step2).setNext(step3).setNext(finalStep);
        return step1;
    }
}
