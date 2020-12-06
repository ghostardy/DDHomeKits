package family.dd.DDHomeKits.member.handler;

public class LoginHandlerFactory {
    public LoginHandler getInstance() {
        LoginHandler step1 = new LoginUserStatusHandler();
        LoginHandler step2 = new LoginAuthorizationHandler();
        LoginHandler finalStep = new LoginSuccessHandler();
        step1.setNext(step2).setNext(finalStep);
        return step1;
    }
}
