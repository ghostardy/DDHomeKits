package family.dd.DDHomeKits.member;

import family.dd.DDHomeKits.defination.ResponseCode;
import family.dd.DDHomeKits.entity.HandleResult;
import family.dd.DDHomeKits.entity.UserInfo;
import family.dd.DDHomeKits.entity.UserRole;
import family.dd.DDHomeKits.member.handler.LoginHandler;
import family.dd.DDHomeKits.member.handler.LoginHandlerFactory;
import family.dd.DDHomeKits.member.handler.PasswordHandler;
import family.dd.DDHomeKits.member.handler.PasswordHandlerFactory;
import family.dd.DDHomeKits.member.role.FamilyRole;

import java.util.HashSet;

import static family.dd.DDHomeKits.util.CommonUtil.isEmptyString;
import static family.dd.DDHomeKits.util.CommonUtil.isNull;

/**
 * Users action as family member
 */
public class FamilyMember {
    private FamilyRole role;
    private FamilyMemberRepository repository ;
    private LoginHandlerFactory loginHandlerFactory;


    HandleResult recover(String memberId){
        return new HandleResult(ResponseCode.SUCCESS, "Family member login status is recovered");
    }

    /**
     * Authorize user and put user info into cache
     * @param username username inputted by user
     * @param password password inputted by front user
     * @return HandleResult
     */
    public HandleResult login(String username, String password){
        UserInfo[] users = repository.getUserInfo(username);

        if (users.length!=1){
            return new HandleResult(ResponseCode.REQUEST_UNAUTHORIZED, "Invalid account or password");
        }else {
            //int pwdStrategy = users[0].getExtraInfo().getPwdStrategy();
            int pwdStrategy = 1;
            PasswordHandler pwdHandler = new PasswordHandlerFactory().getInstance(pwdStrategy);
            HandleResult pwdHandleResult = pwdHandler.handle(new UserInfo(username, password));

            if (!pwdHandleResult.getCode().equals(ResponseCode.SUCCESS)){
                return new HandleResult(ResponseCode.SERVER_ERROR, "Login Failed! Detail : " + pwdHandleResult.getMessage());
            } else if (!pwdHandleResult.getMessage().equals(users[0].getPassword())) {
                return new HandleResult(ResponseCode.REQUEST_UNAUTHORIZED, "Invalid account or password");
            } else {
                LoginHandler loginHandler = loginHandlerFactory.getInstance();
                return loginHandler.handle(users[0]);
            }
        }
    }

    /**
     * Summary authority from user roles
     * @param user Entity of family member
     * @return long value of authority
     */
//    public long getUserAuthority(UserInfo user){
//        long authority = 0L;
//        if (isNull(user)) {
//            return authority;
//        }
//        HashSet<UserRole> roleList = user.getRole();
//        if (!roleList.isEmpty()) {
//            for (UserRole role : roleList) {
//                authority &= role.getAuthority();
//            }
//        }
//        return authority;
//    }

    UserInfo getUserInfo(int memberId) {
        return new UserInfo("","");
    }

    boolean checkPassword(UserInfo user, String password){
        return isEmptyString(password)? false : user.getPassword().equals(password);
    }
}
