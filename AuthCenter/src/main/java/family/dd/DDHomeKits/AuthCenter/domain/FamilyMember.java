package family.dd.DDHomeKits.AuthCenter.domain;

import family.dd.DDHomeKits.AuthCenter.dao.FamilyMemberRepository;
import family.dd.DDHomeKits.AuthCenter.dao.IdentificationPO;
import family.dd.DDHomeKits.AuthCenter.definition.ResponseCode;
import family.dd.DDHomeKits.AuthCenter.dao.HandleResult;
import family.dd.DDHomeKits.AuthCenter.domain.handler.LoginHandler;
import family.dd.DDHomeKits.AuthCenter.domain.handler.LoginHandlerFactory;
import family.dd.DDHomeKits.AuthCenter.domain.handler.PasswordHandler;
import family.dd.DDHomeKits.AuthCenter.domain.handler.PasswordHandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    HandleResult login(IdentificationPO familyMember){
        /**
         * Check password inputted by front user
         */
        HandleResult pwdHandleResult = transPassword(familyMember);
        if (!pwdHandleResult.getCode().equals(ResponseCode.SUCCESS)) {
            return new HandleResult(ResponseCode.SERVER_ERROR, "Login Failed! Detail : " + pwdHandleResult.getMessage());
        }
        String handledPassword = pwdHandleResult.getMessage();
        List<IdentificationPO> members = repository.getUserInfo(familyMember.getUsername(), handledPassword);

        if(members.size() != 1) {
            return new HandleResult(ResponseCode.REQUEST_FAILURE, "Login Failed! Invalid username or password");
        }

        LoginHandler loginHandler = LoginHandlerFactory.getInstance();
        return loginHandler.handle(members.get(0));
    }

    HandleResult transPassword(IdentificationPO userInfo){
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
    HandleResult singUp(IdentificationPO userInfo){
        /**
         * Check if username can be use
         */
        List<IdentificationPO> users;
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
        IdentificationPO newUser = new IdentificationPO(userInfo);
        newUser.setPassword(pwdHandleResult.getMessage());
        /**
         * Store new user info into database
         */
        try {
            //repository.addUserInfo(newUser);
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
    private HandleResult handlePassword(IdentificationPO userInfo) {
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
