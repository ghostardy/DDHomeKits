package family.dd.member.role;

import family.dd.entity.UserRole;
import java.util.HashMap;


public class FamilyRole {
    private FamilyRoleRepository repository;
    private static HashMap<Integer, UserRole> roles;

    public FamilyRole(){
        load();
    }

    public UserRole getFamilyRoleInfo(Integer roleId){
        return roles.get(roleId);
    }

    public void load(){
        //load UserRole from db
    }
}
