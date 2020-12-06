package family.dd.DDHomeKits.member.handler;

import family.dd.DDHomeKits.defination.ResponseCode;
import family.dd.DDHomeKits.entity.HandleResult;
import family.dd.DDHomeKits.entity.UserInfo;

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
