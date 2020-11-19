package family.dd.member.entity;

import family.dd.member.ResponseCode;

public class HandleResult {
    private ResponseCode code;
    private String message;

    HandleResult(){
        this.code = ResponseCode.HANDLING;
        this.message = "Handling request";
    }

    HandleResult(ResponseCode code, String message){
        this.code = code;
        this.message = message;
    }

    public ResponseCode getCode() {
        return code;
    }

    public void setCode(ResponseCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
