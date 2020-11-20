package family.dd.defination;

public enum UserStatus {
    PREPARED(0),
    INITIALIZED(1),
    FREEZE_UP(2),
    DELETED(9),
    UNKNOWN(99);
    private int status;
    UserStatus(int status){
        this.status = status;
    }
    public int getIntValue(){
        return status;
    }
}
