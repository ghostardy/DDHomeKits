package family.dd.entity;

import family.dd.defination.UserStatus;

import java.util.Date;
import java.util.HashSet;

public class UserInfo {
     private int memberId;
     private String account;
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

     public String getAccount() {
          return account;
     }

     public void setAccount(String account) {
          this.account = account;
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
