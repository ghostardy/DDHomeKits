package family.dd.DDHomeKits.AuthCenter.domain.handler;

import family.dd.DDHomeKits.AuthCenter.dao.UserIdentityPO;
import family.dd.DDHomeKits.AuthCenter.definition.ResponseCode;
import family.dd.DDHomeKits.AuthCenter.definition.UserStatus;
import family.dd.DDHomeKits.AuthCenter.dao.HandleResult;

class LoginUserStatusHandler extends LoginHandler{
    public HandleResult handle(UserIdentityPO user){
        if (!user.getStatus().equals(UserStatus.PREPARED)) {
            return new HandleResult(ResponseCode.REQUEST_UNAUTHORIZED, "Family member status error");
        }else {
            return next.handle(user);
        }
    }
}
