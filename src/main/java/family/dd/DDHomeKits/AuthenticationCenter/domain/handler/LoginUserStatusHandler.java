package family.dd.DDHomeKits.AuthenticationCenter.domain.handler;

import family.dd.DDHomeKits.AuthenticationCenter.definition.ResponseCode;
import family.dd.DDHomeKits.AuthenticationCenter.definition.UserStatus;
import family.dd.DDHomeKits.AuthenticationCenter.dao.HandleResult;
import family.dd.DDHomeKits.AuthenticationCenter.dao.UserInfo;

class LoginUserStatusHandler extends LoginHandler{
    public HandleResult handle(UserInfo user){
        if (!user.getStatus().equals(UserStatus.PREPARED)) {
            return new HandleResult(ResponseCode.REQUEST_UNAUTHORIZED, "Family member status error");
        }else {
            return next.handle(user);
        }
    }
}
