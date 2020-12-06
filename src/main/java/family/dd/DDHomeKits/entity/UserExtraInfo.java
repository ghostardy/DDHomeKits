package family.dd.DDHomeKits.entity;

public class UserExtraInfo {
    /**
     * Version of password safe strategy
     * Current default version is 1
     */
    private int pwdStrategy=1;

    public int getPwdStrategy() {
        return pwdStrategy;
    }

    public void setPwdStrategy(int pwdStrategy) {
        this.pwdStrategy = pwdStrategy;
    }
}
