package family.dd.DDHomeKits.AuthCenter.domain.handler;

import family.dd.DDHomeKits.AuthCenter.definition.ResponseCode;
import family.dd.DDHomeKits.AuthCenter.definition.UserStatus;
import family.dd.DDHomeKits.AuthCenter.dao.HandleResult;
import family.dd.DDHomeKits.AuthCenter.dao.IdentificationPO;

class LoginUserStatusHandler extends LoginHandler{
    public HandleResult handle(IdentificationPO user){
        if (!user.getStatus().equals(UserStatus.PREPARED)) {
            return new HandleResult(ResponseCode.REQUEST_UNAUTHORIZED, "Family member status error");
        }else {
            return next.handle(user);
        }
    }
}
