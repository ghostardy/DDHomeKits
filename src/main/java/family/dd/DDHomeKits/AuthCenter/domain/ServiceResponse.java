package family.dd.DDHomeKits.AuthCenter.domain;

import family.dd.DDHomeKits.AuthCenter.definition.ResponseCode;

public class ServiceResponse {
    private int code= ResponseCode.HANDLING.getCodeValue();
    private String message="handling";
    private String data="{}";

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String toJson(){
        return "{\"code\":\""+ code +",\"message\":\""+message+"\",\"data\":\""+data+"\"}";
    }
}
