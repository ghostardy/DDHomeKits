package family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity.handler;

import family.dd.DDHomeKits.AuthCenter.infrastructure.util.CommonUtil;

public class PasswordSimpleSaltHandler extends PasswordHandler{
    private static final String SIMPLE_SALT = "My-name-is-link-not-Zelda-also-not-Luigi!";

    @Override
    public String handle(String source, String...seed) throws Exception{
        String key = "";
        if (seed.length > 0) {
            key = seed[0];
        }
        String target = key + source + SIMPLE_SALT;
        if (CommonUtil.isNull(next)) {
            return target;
        }else {
            return next.handle(target, seed);
        }
    }

    public static String getSimpleSalt(){
        return SIMPLE_SALT;
    }
}
