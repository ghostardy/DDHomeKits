package family.dd.DDHomeKits.definition;

/**
 * Define user status
 * Only user with PREPARED(0) status is available
 */
public enum UserStatus {
    PREPARED(0),
    INITIALIZED(1),
    FREEZE_UP(2),
    DELETED(9),
    UNKNOWN(99);
    private int statusCode;
    UserStatus(int statusCode){
        this.statusCode = statusCode;
    }
    /**
     * @return int value of user status code
     */
    public int getStatusCode(){
        return statusCode;
    }
    public static UserStatus getUserStatus(int statusCode){
        for(UserStatus us : UserStatus.values()){
            if (statusCode == us.getStatusCode()){
                return us;
            }
        }
        return UserStatus.UNKNOWN;
    }
}
