package family.dd.DDHomeKits.AuthenticationCenter.domain.handler;

import family.dd.DDHomeKits.AuthenticationCenter.definition.Privilege;
import family.dd.DDHomeKits.AuthenticationCenter.definition.ResponseCode;
import family.dd.DDHomeKits.AuthenticationCenter.dao.HandleResult;
import family.dd.DDHomeKits.AuthenticationCenter.dao.UserInfo;

class LoginAuthorizationHandler extends LoginHandler {
    public HandleResult handle(UserInfo user){
        if(Privilege.hasPermission(0L, Privilege.LOG_IN)) {
            return new HandleResult(ResponseCode.REQUEST_UNAUTHORIZED, "Family member is unauthorized");
        } else {
            return next.handle(user);
        }
    }
}
