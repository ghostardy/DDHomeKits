package family.dd.member;

import family.dd.defination.ResponseCode;
import family.dd.defination.UserStatus;
import family.dd.entity.HandleResult;
import family.dd.entity.UserInfo;
import family.dd.entity.UserRole;
import family.dd.member.handler.LoginHandler;
import family.dd.member.handler.LoginHandlerFactory;
import family.dd.member.role.FamilyRole;

import java.util.HashSet;

import static family.dd.common.util.CommonUtil.isEmptyString;
import static family.dd.common.util.CommonUtil.isNull;

/**
 * Users action as family member
 */
public class FamilyMember {
    private FamilyRole role;
    private FamilyMemberRepository repository ;


    HandleResult recover(String memberId){
        return new HandleResult(ResponseCode.SUCCESS, "Family member login status is recovered");
    }

    /**
     * Authorize user and put userinfo into cache
     * @param username username inputted by user
     * @param encryptedPwd password inputted by user and encrypted by SafetyGuarder in FamilyMemberService
     * @return HandleResult
     */
    public HandleResult login(String username, String encryptedPwd){
        UserInfo[] users = repository.getUserInfo(username, encryptedPwd);
        if (users.length!=1){
            return new HandleResult(ResponseCode.REQUEST_UNAUTHORIZED, "Invalid account or password");
        }else {
            LoginHandler handlerChain = new LoginHandlerFactory().getInstance();
            return handlerChain.handle(users[0]);
        }
    }

    public long getAuthority(UserInfo user){
        long authority = 0L;
        HashSet<UserRole> roleList = user.getRole();
        if (roleList.isEmpty()) {
            return authority;
        } else {
            for (UserRole role : roleList) {
                authority &= role.getAuthority();
            }
            return authority;
        }
    }

    UserInfo getUserInfo(int memberId) {
        return new UserInfo();
    }

    boolean checkPassword(UserInfo user, String password){
        return isEmptyString(password)? false : user.getPassword().equals(password);
    }
}
