package family.dd.DDHomeKits.member;

import family.dd.DDHomeKits.definition.ResponseCode;
import family.dd.DDHomeKits.entity.HandleResult;
import family.dd.DDHomeKits.entity.UserInfo;
import family.dd.DDHomeKits.member.handler.LoginHandler;
import family.dd.DDHomeKits.member.handler.LoginHandlerFactory;
import family.dd.DDHomeKits.member.handler.PasswordHandler;
import family.dd.DDHomeKits.member.handler.PasswordHandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static family.dd.DDHomeKits.util.CommonUtil.isEmptyString;

/**
 * Users action as family member
 */
@Service
public class FamilyMember {
    private FamilyMemberRepository repository ;

    HandleResult recover(String memberId){
        return new HandleResult(ResponseCode.SUCCESS, "Family member login status is recovered");
    }

    /**
     * Authorize user and put user info into cache
     * @param familyMember login information gathered by client
     * @return HandleResult
     */
    HandleResult login(UserInfo familyMember){
        /**
         * Check password inputted by front user
         */
        HandleResult pwdHandleResult = transPassword(familyMember);
        if (!pwdHandleResult.getCode().equals(ResponseCode.SUCCESS)) {
            return new HandleResult(ResponseCode.SERVER_ERROR, "Login Failed! Detail : " + pwdHandleResult.getMessage());
        }
        String handledPassword = pwdHandleResult.getMessage();
        List<UserInfo> members = repository.getUserInfo(familyMember.getUsername(), handledPassword);

        if(members.size() != 1) {
            return new HandleResult(ResponseCode.REQUEST_FAILURE, "Login Failed! Invalid username or password");
        }

        LoginHandler loginHandler = LoginHandlerFactory.getInstance();
        return loginHandler.handle(members.get(0));
    }

    HandleResult transPassword(UserInfo userInfo){
        /**
         * Handle password inputted by front user
         */
        PasswordHandler pwdHandler = PasswordHandlerFactory.getInstance();
        return pwdHandler.handle(userInfo);
    }
    /**
     * Sign up new user, only used by inner service
     * @param userInfo
     * @return HandleResult
     */
    HandleResult singUp(UserInfo userInfo){
        /**
         * Check if username can be use
         */
        List<UserInfo> users;
        try {
            users = repository.getUserInfo(userInfo.getUsername());
        }catch (Exception e) {
            e.printStackTrace();
            return new HandleResult(ResponseCode.SERVER_ERROR, "Failed to sign up user, please try again later");
        }
        if(users.size() != 0) {
            return new HandleResult(ResponseCode.REQUEST_FAILURE, "Can not sign up by username: " +
                    userInfo.getUsername() + ". Please try another one.");
        }
        /**
         * Trans password inputted by front user
         */
        HandleResult pwdHandleResult = handlePassword(userInfo);
        if (!pwdHandleResult.getCode().equals(ResponseCode.SUCCESS)){
            return pwdHandleResult;
        }
        UserInfo newUser = new UserInfo(userInfo);
        newUser.setPassword(pwdHandleResult.getMessage());
        /**
         * Store new user info into database
         */
        try {
            repository.addUserInfo(newUser);
            return new HandleResult(ResponseCode.SUCCESS, "Thanks for Signing Up");
        }catch (Exception e) {
            e.printStackTrace();
            return new HandleResult(ResponseCode.SERVER_ERROR, "Failed to add new user");
        }
    }

    /**
     * Trans Password in order to store in repository
     * @param userInfo
     * @return HandleResult
     */
    private HandleResult handlePassword(UserInfo userInfo) {
        PasswordHandler passwordHandler = PasswordHandlerFactory.getInstance();
        return passwordHandler.handle(userInfo);
    }

    public FamilyMemberRepository getRepository() {
        return repository;
    }

    @Autowired
    public void setRepository(FamilyMemberRepository repository) {
        this.repository = repository;
    }
}
