package family.dd.DDHomeKits.member.handler;

import family.dd.DDHomeKits.definition.ResponseCode;
import family.dd.DDHomeKits.definition.UserStatus;
import family.dd.DDHomeKits.entity.HandleResult;
import family.dd.DDHomeKits.entity.UserInfo;

class LoginUserStatusHandler extends LoginHandler{
    public HandleResult handle(UserInfo user){
        if (!user.getStatus().equals(UserStatus.PREPARED)) {
            return new HandleResult(ResponseCode.REQUEST_UNAUTHORIZED, "Family member status error");
        }else {
            return next.handle(user);
        }
    }
}
