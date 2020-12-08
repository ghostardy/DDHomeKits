package family.dd.DDHomeKits.entity;

import family.dd.DDHomeKits.definition.ResponseCode;

public class HandleResult {
    private ResponseCode code;
    private String message;

    public HandleResult(){
        this(ResponseCode.HANDLING, "Handling request");
    }

    public HandleResult(ResponseCode code, String message){
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
