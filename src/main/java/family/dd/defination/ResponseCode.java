package family.dd.defination;

public enum ResponseCode {
    HANDLING(100),
    SUCCESS(200),
    REQUEST_FAILURE(400),
    REQUEST_UNAUTHORIZED(401),
    REQUEST_FORBIDDEN(403),
    SERVER_ERROR(500),
    UNKNOWN(999);


    private int code;
    ResponseCode(int code){
        this.code = code;
    }

    public int getCodeValue() {
        return code;
    }
}
