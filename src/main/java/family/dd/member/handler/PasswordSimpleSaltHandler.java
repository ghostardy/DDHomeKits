package family.dd.member.handler;

import family.dd.defination.ResponseCode;
import family.dd.entity.HandleResult;
import family.dd.entity.UserInfo;

import static family.dd.common.util.CommonUtil.isNull;

public class PasswordSimpleSaltHandler extends PasswordHandler{
    private final String SIMPLE_SALT = "My-name-is-link-not-Zelda-also-not-Luigi!";

    @Override
    public HandleResult handle(UserInfo user) {
        if (isNull(user)) {
            return new HandleResult(ResponseCode.SERVER_ERROR, "failed to salt password");
        }
        String pwdWithSalt = user.getUsername() + user.getPassword() + SIMPLE_SALT;
        if (isNull(next)) {
            return new HandleResult(ResponseCode.SUCCESS, pwdWithSalt);
        }else {
            user.setPassword(pwdWithSalt);
            return next.handle(user);
        }
    }
}
