package family.dd.member.handler;

import family.dd.defination.ResponseCode;
import family.dd.defination.UserStatus;
import family.dd.entity.HandleResult;
import family.dd.entity.UserInfo;

class LoginUserStatusHandler extends LoginHandler{
    public HandleResult handle(UserInfo user){
        if (user.getStatus().equals(UserStatus.PREPARED)) {
            return new HandleResult(ResponseCode.REQUEST_UNAUTHORIZED, "Family member login succeed");
        }else {
            return next.handle(user);
        }
    }
}
