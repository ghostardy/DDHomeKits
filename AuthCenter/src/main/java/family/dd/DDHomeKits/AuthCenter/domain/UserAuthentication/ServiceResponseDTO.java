package family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication;

import com.google.gson.Gson;
import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity.ResponseCode;

public class ServiceResponseDTO {
    private ResponseCode code= ResponseCode.HANDLING;
    private String message="handling";
    private Object data=null;
    private Gson gson;

    public ServiceResponseDTO() {}
    public ServiceResponseDTO(ResponseCode responseCode, String message, Object data){
        this.code = responseCode;
        this.message = message;
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String toJson(){
        return gson.toJson(this);
    }
}
