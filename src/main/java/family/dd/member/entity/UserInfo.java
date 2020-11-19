package family.dd.member.entity;

import java.util.Date;

public class UserInfo {
     private int memberId;
     private String account;
     private String password;
     private String nickName;
     private int status;
     private String role;
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

     public int getStatus() {
          return status;
     }

     public void setStatus(int status) {
          this.status = status;
     }

     public String getRole() {
          return role;
     }

     public void setRole(String role) {
          this.role = role;
     }

     public Date getSignUpDate() {
          return signUpDate;
     }

     public void setSignUpDate(Date signUpDate) {
          this.signUpDate = signUpDate;
     }
}
