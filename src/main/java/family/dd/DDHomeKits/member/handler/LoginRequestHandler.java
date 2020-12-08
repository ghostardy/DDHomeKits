package family.dd.DDHomeKits.member.handler;

import family.dd.DDHomeKits.definition.ResponseCode;
import family.dd.DDHomeKits.entity.HandleResult;
import family.dd.DDHomeKits.entity.UserInfo;

import java.util.List;

public class LoginRequestHandler extends LoginHandler {
    @Override
    public HandleResult handle(UserInfo user) {
        /**
         * Handle password inputted by front user
         */
        PasswordHandler pwdHandler = PasswordHandlerFactory.getInstance();
        HandleResult pwdHandleResult = pwdHandler.handle(user);
        if (!pwdHandleResult.getCode().equals(ResponseCode.SUCCESS)) {
            return new HandleResult(ResponseCode.SERVER_ERROR, "Login Failed! Detail : " + pwdHandleResult.getMessage());
        }
        String handledPassword = pwdHandleResult.getMessage();
        List<UserInfo> users = familyMemberRepository.getUserInfo(user.getUsername(), handledPassword);

        if (users.size()!=1){
            return new HandleResult(ResponseCode.REQUEST_UNAUTHORIZED, "Invalid account or password");
        }else {
            return next.handle(users.get(0));
        }
    }
}
