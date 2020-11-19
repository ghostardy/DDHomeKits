package family.dd.member;


import family.dd.member.entity.HandleResult;
import family.dd.member.entity.UserInfo;

public class FamilyMember {
    //private FamilyRole role;
    //private UserInfoRepository userInfoRepository;
    private FamilyMemberDAO dao ;

    private enum UserStatus{
        PREPARED(0),
        INITIALIZED(1),
        FREEZE_UP(2),
        DELETED(9),
        UNKNOWN(99);
        private int status;
        UserStatus(int status){
            this.status = status;
        }
        public int getIntValue(){
            return status;
        }
    }
    HandleResult recover(String memberId){
        return new HandleResult(ResponseCode.SUCCESS, "Family member login status recoverd");
    }

    private abstract class LoginHandler{
        protected LoginHandler next;
        protected LoginHandler setNext(LoginHandler next){
            return this.next = next;
        }
        abstract HandleResult handle(UserInfo user);
    }

    private class LoginAuthorizationHandler extends LoginHandler{
        HandleResult handle(UserInfo user){
            if(!hasPermission(user, Privilege.LOG_IN)) {
                return new HandleResult(ResponseCode.REQUEST_UNAUTHORIZED, "Family member login succeed");
            }else {
                return next.handle(user);
            }
        }
    }
    private class LoginUserStatusHandler extends LoginHandler{
        HandleResult handle(UserInfo user){
            if (UserStatus.PREPARED.getIntValue() == user.getStatus()) {
                return new HandleResult(ResponseCode.REQUEST_UNAUTHORIZED, "Family member login succeed");
            }else {
                return next.handle(user);
            }
        }
    }
    private class LoginSuccessHandler extends LoginHandler{
        HandleResult handle(UserInfo user){
            //write userinfo into memory cache
            return new HandleResult(ResponseCode.SUCCESS, "Family member login succeed");
        }
    }

    private class LoginHandlerChainFactory{
        public LoginHandler getInstance() {
            LoginHandler step1 = new LoginUserStatusHandler();
            LoginHandler step2 = new LoginAuthorizationHandler();
            LoginHandler step3 = new LoginSuccessHandler();
            step1.setNext(step2).setNext(step3);
            return step1;
        }
    }

    HandleResult login(String account, String encryptedPwd){
        UserInfo[] users = dao.getUserInfo(account, encryptedPwd);
        if (users.length!=1){
            return new HandleResult(ResponseCode.REQUEST_UNAUTHORIZED, "Invalid account or password");
        }else {
            LoginHandler handlerChain = new LoginHandlerChainFactory().getInstance();
            return handlerChain.handle(users[0]);
        }
    }

    long loadAuthority(String memberId){
        return 0L;
    }

    boolean hasPermission(UserInfo user, Privilege...privileges){
        return true;
    }



    UserInfo getUserInfoByMemberId(int memberId) {
        return new UserInfo();
    }

    boolean checkPassword(UserInfo user, String password){
        return isEmptyString(password)? false : user.getPassword().equals(password);
    }
    boolean isEmptyString(String str) {
        return null==str||str.isEmpty()||str.equals("");
    }
}
