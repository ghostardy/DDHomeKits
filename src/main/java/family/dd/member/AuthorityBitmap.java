package family.dd.member;

public enum AuthorityBitmap {
    SIGN_IN(1, "Sign in"),
    ROLE_MANAGE(2, "Manage family roles"),
    MEMBER_MANAGE(3, "Manage family members");

    private int bit;
    private String description;
    AuthorityBitmap(int bit, String description){
        this.bit = bit;
        this.description = description;
    }
    public static long getAuthorityOnBit(int bit){
        return 0L;
    }
    public static boolean hasPermission(AuthorityBitmap bitmap, long authority){
        return true;
    }
}
