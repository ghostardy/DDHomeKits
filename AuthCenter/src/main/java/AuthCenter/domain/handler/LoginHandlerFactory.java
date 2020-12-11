package family.dd.DDHomeKits.AuthCenter.domain.handler;

public class LoginHandlerFactory {
    public static LoginHandler getInstance() {
        /**
         * LoginRequestHandler must be the first handler in order to get full user information
         */
        LoginHandler step1 = new LoginRequestHandler();
        LoginHandler step2 = new LoginAuthorizationHandler();
        LoginHandler step3 = new LoginUserStatusHandler();
        LoginHandler step4 = new LoginSuccessHandler();
        /**
         * Create handle chain
         */
        step1.setNext(step2).setNext(step3).setNext(step4);

        return step1;
    }
}
