package family.dd.member;

public class FamilyMember {
    private int memberId;
    String account;
    String nickName;
    String password;
    long authority;
    //FamilyRole[] roles;

    void signIn(FamilyMember member){

    }

    long loadAuthority(){
        return 0L;
    }

    boolean hasPermission(String optionName){
        return true;
    }
}
