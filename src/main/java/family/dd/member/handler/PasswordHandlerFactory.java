package family.dd.member.handler;

public class PasswordHandlerFactory {
    public PasswordHandler getInstance(int pwdStrategy){
        switch(pwdStrategy){
            default :
                return generateStrategy1();
        }
    }
    private PasswordHandler generateStrategy1(){
        PasswordHandler step1 = new PasswordSHA256Handler();
        PasswordHandler step2 = new PasswordSimpleSaltHandler();
        PasswordHandler step3 = step1;
        PasswordHandler finalStep = step2;
        step1.setNext(step2).setNext(step3).setNext(finalStep);
        return step1;
    }
}
