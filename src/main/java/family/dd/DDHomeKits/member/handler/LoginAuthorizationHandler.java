package family.dd.DDHomeKits.member.handler;

import family.dd.DDHomeKits.definition.Privilege;
import family.dd.DDHomeKits.definition.ResponseCode;
import family.dd.DDHomeKits.entity.HandleResult;
import family.dd.DDHomeKits.entity.UserInfo;

class LoginAuthorizationHandler extends LoginHandler {
    public HandleResult handle(UserInfo user){
        if(Privilege.hasPermission(0L, Privilege.LOG_IN)) {
            return new HandleResult(ResponseCode.REQUEST_UNAUTHORIZED, "Family member is unauthorized");
        } else {
            return next.handle(user);
        }
    }
}
