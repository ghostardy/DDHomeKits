package family.dd.DDHomeKits.AuthCenter.dao;

import com.google.gson.Gson;
import family.dd.DDHomeKits.AuthCenter.definition.UserStatus;

import java.sql.Timestamp;

/**
 * Entity of Database, UserIdentityPO table
 * UserStatus need to TransType to int
 */
public class UserIdentityPO {
     private int userId;
     private String username;
     private String password;
     private UserStatus status;
     private long authority;
     private Timestamp signUpDate;

     public UserIdentityPO() {
          this("", "");
     }
     public UserIdentityPO(String username, String password) {
          this.username = username;
          this.password = password;
          this.status = UserStatus.INITIALIZED;
          this.authority = 0L;
          this.signUpDate = new Timestamp(System.currentTimeMillis());
     }
     public UserIdentityPO(UserIdentityPO userInfo){
          this.username = userInfo.getUsername();
          this.password = userInfo.getPassword();
          this.status = userInfo.getStatus();
          this.authority = userInfo.getAuthority();
          this.signUpDate = userInfo.getSignUpDate();
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

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
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
