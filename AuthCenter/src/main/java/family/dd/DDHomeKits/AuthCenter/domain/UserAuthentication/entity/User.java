package family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity;

import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.repository.UserIdentityPO;
import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.repository.HandleResult;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

/**
 * Users action as family member
 */
@Component
@Scope("prototype")
public class User {
    private int userId;
    private String username;
    private UserStatus status;
    private long authority;
    private Timestamp signUpDate;
    private String sessionId;
    public String getSessionId() {
        return sessionId;
    }
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public User(){}
    public User(UserIdentityPO userPO){
        this.userId = userPO.getUserId();
        this.username = userPO.getUsername();
        this.status = userPO.getStatus();
        this.authority = userPO.getAuthority();
        this.signUpDate = userPO.getSignUpDate();
    }

    HandleResult recover(String memberId){
        return new HandleResult(ResponseCode.SUCCESS, "Family member login status is recovered");
    }

    public void login(){
        System.out.println("logged in");
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public long getAuthority() {
        return authority;
    }

    public void setAuthority(long authority) {
        this.authority = authority;
    }

    public Timestamp getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(Timestamp signUpDate) {
        this.signUpDate = signUpDate;
    }
}
