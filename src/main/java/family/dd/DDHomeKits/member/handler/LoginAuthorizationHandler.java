package family.dd.DDHomeKits.member.handler;

import family.dd.DDHomeKits.defination.Privilege;
import family.dd.DDHomeKits.defination.ResponseCode;
import family.dd.DDHomeKits.entity.HandleResult;
import family.dd.DDHomeKits.entity.UserInfo;

class LoginAuthorizationHandler extends LoginHandler {
    public HandleResult handle(UserInfo user){
        if(Privilege.hasPermission(0L, Privilege.LOG_IN)) {
            return new HandleResult(ResponseCode.REQUEST_UNAUTHORIZED, "Family member login succeed");
        } else {
            return next.handle(user);
        }
    }
}
