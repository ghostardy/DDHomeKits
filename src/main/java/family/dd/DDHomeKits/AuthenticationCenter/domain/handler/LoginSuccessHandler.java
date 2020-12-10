package family.dd.DDHomeKits.AuthenticationCenter.domain.handler;

import family.dd.DDHomeKits.AuthenticationCenter.definition.ResponseCode;
import family.dd.DDHomeKits.AuthenticationCenter.dao.HandleResult;
import family.dd.DDHomeKits.AuthenticationCenter.dao.UserInfo;

class LoginSuccessHandler extends LoginHandler{
    public HandleResult handle(UserInfo user){
        //write userinfo into memory cache
        loadAuthority(user);
        return new HandleResult(ResponseCode.SUCCESS, "Family member login succeed");
    }
    long loadAuthority(UserInfo user){
        return 0L;
    }
}
