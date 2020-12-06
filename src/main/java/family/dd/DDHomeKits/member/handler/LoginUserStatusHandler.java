package family.dd.DDHomeKits.member.handler;

import family.dd.DDHomeKits.defination.ResponseCode;
import family.dd.DDHomeKits.defination.UserStatus;
import family.dd.DDHomeKits.entity.HandleResult;
import family.dd.DDHomeKits.entity.UserInfo;

class LoginUserStatusHandler extends LoginHandler{
    public HandleResult handle(UserInfo user){
        if (user.getStatus().equals(UserStatus.PREPARED)) {
            return new HandleResult(ResponseCode.REQUEST_UNAUTHORIZED, "Family member login succeed");
        }else {
            return next.handle(user);
        }
    }
}
