package family.dd.DDHomeKits.entity;

import family.dd.DDHomeKits.defination.UserStatus;

import java.sql.Timestamp;

/**
 * Entity of Database, UserInfo table
 * UserStatus need to TransType to int
 */
public class UserInfo {
     private int userId;
     private String username;
     private String password;
     private String nickName;
     private UserStatus status;
     private long authority;
     private String extraInfo;
     private Timestamp signUpDate;

     public UserInfo() {
          this("", "");
     }
     public UserInfo(String username, String password) {
          this.username = username;
          this.password = password;
          this.authority = 0L;
          this.extraInfo = "{}";
          this.signUpDate = new Timestamp(System.currentTimeMillis());
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

     public String getNickName() {
          return nickName;
     }

     public void setNickName(String nickName) {
          this.nickName = nickName;
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

     public String getExtraInfo() {
          return extraInfo;
     }

     public void setExtraInfo(String extraInfo) {
          this.extraInfo = extraInfo;
     }

     public Timestamp getSignUpDate() {
          return signUpDate;
     }

     public void setSignUpDate(Timestamp signUpDate) {
          this.signUpDate = signUpDate;
     }
}
