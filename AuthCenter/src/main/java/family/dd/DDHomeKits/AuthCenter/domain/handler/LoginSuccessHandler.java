package family.dd.DDHomeKits.AuthCenter.domain.handler;

import family.dd.DDHomeKits.AuthCenter.dao.UserIdentityPO;
import family.dd.DDHomeKits.AuthCenter.definition.ResponseCode;
import family.dd.DDHomeKits.AuthCenter.dao.HandleResult;

class LoginSuccessHandler extends LoginHandler{
    public HandleResult handle(UserIdentityPO user){
        //write userinfo into memory cache
        loadAuthority(user);
        return new HandleResult(ResponseCode.SUCCESS, "Family member login succeed");
    }
    long loadAuthority(UserIdentityPO user){
        return 0L;
    }
}
