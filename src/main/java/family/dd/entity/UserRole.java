package family.dd.entity;

import java.util.Date;

public class UserRole {
    private int roleId;
    private String roleName;
    private long authority;
    private String description;
    private Date signUpDate;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public long getAuthority() {
        return authority;
    }

    public void setAuthority(long authority) {
        this.authority = authority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(Date signUpDate) {
        this.signUpDate = signUpDate;
    }
}
