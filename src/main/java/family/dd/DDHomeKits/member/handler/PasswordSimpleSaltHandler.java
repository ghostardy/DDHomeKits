package family.dd.DDHomeKits.member.handler;

import family.dd.DDHomeKits.definition.ResponseCode;
import family.dd.DDHomeKits.entity.HandleResult;
import family.dd.DDHomeKits.entity.UserInfo;

import static family.dd.DDHomeKits.util.CommonUtil.isNull;

public class PasswordSimpleSaltHandler extends PasswordHandler{
    private static final String SIMPLE_SALT = "My-name-is-link-not-Zelda-also-not-Luigi!";

    @Override
    public HandleResult handle(UserInfo user) {
        if (isNull(user)) {
            return new HandleResult(ResponseCode.SERVER_ERROR, "failed to salt password");
        }
        String pwdWithSalt = user.getUsername() + user.getPassword() + SIMPLE_SALT;
        if (isNull(next)) {
            return new HandleResult(ResponseCode.SUCCESS, pwdWithSalt);
        }else {
            UserInfo ui = new UserInfo(user);
            ui.setPassword(pwdWithSalt);
            return next.handle(ui);
        }
    }

    static String getSalt(){
        return SIMPLE_SALT;
    }
}
