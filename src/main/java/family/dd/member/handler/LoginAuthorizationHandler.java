package family.dd.member.handler;

import family.dd.defination.Privilege;
import family.dd.defination.ResponseCode;
import family.dd.entity.HandleResult;
import family.dd.entity.UserInfo;

class LoginAuthorizationHandler extends LoginHandler {
    public HandleResult handle(UserInfo user){
        if(Privilege.hasPermission(0L, Privilege.LOG_IN)) {
            return new HandleResult(ResponseCode.REQUEST_UNAUTHORIZED, "Family member login succeed");
        } else {
            return next.handle(user);
        }
    }
}
