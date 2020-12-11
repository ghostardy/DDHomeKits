package family.dd.DDHomeKits.AuthCenter.domain.handler;

import family.dd.DDHomeKits.AuthCenter.definition.Privilege;
import family.dd.DDHomeKits.AuthCenter.definition.ResponseCode;
import family.dd.DDHomeKits.AuthCenter.dao.HandleResult;
import family.dd.DDHomeKits.AuthCenter.dao.IdentificationPO;

class LoginAuthorizationHandler extends LoginHandler {
    public HandleResult handle(IdentificationPO user){
        if(Privilege.hasPermission(0L, Privilege.LOG_IN)) {
            return new HandleResult(ResponseCode.REQUEST_UNAUTHORIZED, "Family member is unauthorized");
        } else {
            return next.handle(user);
        }
    }
}
