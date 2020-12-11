package family.dd.DDHomeKits.AuthCenter.domain.handler;

import family.dd.DDHomeKits.AuthCenter.dao.IdentificationPO;
import family.dd.DDHomeKits.AuthCenter.definition.ResponseCode;
import family.dd.DDHomeKits.AuthCenter.dao.HandleResult;

class LoginSuccessHandler extends LoginHandler{
    public HandleResult handle(IdentificationPO user){
        //write userinfo into memory cache
        loadAuthority(user);
        return new HandleResult(ResponseCode.SUCCESS, "Family member login succeed");
    }
    long loadAuthority(IdentificationPO user){
        return 0L;
    }
}
