package family.dd.entity;

import family.dd.defination.UserStatus;

import java.util.Date;
import java.util.HashSet;

public class UserInfo {
     private int memberId;
     private String username;
     private String password;
     private String nickName;
     private UserStatus status;
     private HashSet<UserRole> role;
     private Date signUpDate;

     public int getMemberId() {
          return memberId;
     }

     public void setMemberId(int memberId) {
          this.memberId = memberId;
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

     public HashSet<UserRole> getRole() {
          return role;
     }

     public void setRole(HashSet<UserRole> role) {
          this.role = role;
     }

     public Date getSignUpDate() {
          return signUpDate;
     }

     public void setSignUpDate(Date signUpDate) {
          this.signUpDate = signUpDate;
     }
}
