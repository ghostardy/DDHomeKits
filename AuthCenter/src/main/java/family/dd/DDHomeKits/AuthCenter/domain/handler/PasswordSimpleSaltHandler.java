package family.dd.DDHomeKits.AuthCenter.domain.handler;

import static family.dd.DDHomeKits.AuthCenter.util.CommonUtil.isNull;

public class PasswordSimpleSaltHandler extends PasswordHandler{
    private static final String SIMPLE_SALT = "My-name-is-link-not-Zelda-also-not-Luigi!";

    @Override
    public String handle(String source, String...seed) throws Exception{
        String target = seed + source + SIMPLE_SALT;
        if (isNull(next)) {
            return target;
        }else {
            return next.handle(target, seed);
        }
    }

    public static String getSimpleSalt(){
        return SIMPLE_SALT;
    }
}
