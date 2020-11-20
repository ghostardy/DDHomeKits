package family.dd.member;


import family.dd.defination.Privilege;
import family.dd.defination.ResponseCode;
import family.dd.entity.HandleResult;
import family.dd.entity.UserInfo;
import family.dd.member.handler.LoginHandler;
import family.dd.member.handler.LoginHandlerFactory;
import family.dd.member.role.FamilyRole;

import static family.dd.common.util.CommonUtil.isEmptyString;

public class FamilyMember {
    private FamilyRole role;
    //private UserInfoRepository userInfoRepository;
    private FamilyMemberRepository repository ;


    HandleResult recover(String memberId){
        return new HandleResult(ResponseCode.SUCCESS, "Family member login status is recovered");
    }

    HandleResult login(String account, String encryptedPwd){
        UserInfo[] users = repository.getUserInfo(account, encryptedPwd);
        if (users.length!=1){
            return new HandleResult(ResponseCode.REQUEST_UNAUTHORIZED, "Invalid account or password");
        }else {
            LoginHandler handlerChain = new LoginHandlerFactory().getInstance();
            return handlerChain.handle(users[0]);
        }
    }


    public long getAuthority(String memberId){
        return 0L;
    }

    UserInfo getUserInfo(int memberId) {
        return new UserInfo();
    }

    boolean checkPassword(UserInfo user, String password){
        return isEmptyString(password)? false : user.getPassword().equals(password);
    }
}
