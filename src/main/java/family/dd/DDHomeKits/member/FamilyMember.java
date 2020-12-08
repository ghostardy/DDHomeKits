package family.dd.DDHomeKits.member;

import family.dd.DDHomeKits.definition.ResponseCode;
import family.dd.DDHomeKits.entity.HandleResult;
import family.dd.DDHomeKits.entity.UserInfo;
import family.dd.DDHomeKits.member.handler.LoginHandler;
import family.dd.DDHomeKits.member.handler.LoginHandlerFactory;
import family.dd.DDHomeKits.member.handler.PasswordHandler;
import family.dd.DDHomeKits.member.handler.PasswordHandlerFactory;

import java.util.List;

import static family.dd.DDHomeKits.util.CommonUtil.isEmptyString;

/**
 * Users action as family member
 */
public class FamilyMember {
    private FamilyMemberRepository repository ;

    HandleResult recover(String memberId){
        return new HandleResult(ResponseCode.SUCCESS, "Family member login status is recovered");
    }

    /**
     * Authorize user and put user info into cache
     * @param userInfo user information inputted by user or gathered by client
     * @return HandleResult
     */
    public HandleResult login(UserInfo userInfo){
        LoginHandler loginHandler = LoginHandlerFactory.getInstance();
        return loginHandler.handle(userInfo);
    }

    UserInfo getUserInfo(int memberId) {
        return new UserInfo("","");
    }
}
