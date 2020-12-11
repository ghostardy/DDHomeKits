package family.dd.DDHomeKits.AuthCenter.domain.handler;

import family.dd.DDHomeKits.AuthCenter.definition.ResponseCode;
import family.dd.DDHomeKits.AuthCenter.dao.HandleResult;
import family.dd.DDHomeKits.AuthCenter.dao.IdentificationPO;

import static family.dd.DDHomeKits.AuthCenter.util.CommonUtil.isNull;

public class PasswordSimpleSaltHandler extends PasswordHandler{
    private static final String SIMPLE_SALT = "My-name-is-link-not-Zelda-also-not-Luigi!";

    @Override
    public HandleResult handle(IdentificationPO user) {
        if (isNull(user)) {
            return new HandleResult(ResponseCode.SERVER_ERROR, "failed to salt password");
        }
        String pwdWithSalt = user.getUsername() + user.getPassword() + SIMPLE_SALT;
        if (isNull(next)) {
            return new HandleResult(ResponseCode.SUCCESS, pwdWithSalt);
        }else {
            IdentificationPO ui = new IdentificationPO(user);
            ui.setPassword(pwdWithSalt);
            return next.handle(ui);
        }
    }

    static String getSalt(){
        return SIMPLE_SALT;
    }
}
