package family.dd.DDHomeKits.AuthCenter.domain;

import com.google.gson.Gson;
import family.dd.DDHomeKits.AuthCenter.definition.ResponseCode;

public class ServiceResponseDTO {
    private ResponseCode code= ResponseCode.HANDLING;
    private String message="handling";
    private String data="{}";
    private Gson gson;

    public ServiceResponseDTO() {}
    public ServiceResponseDTO(ResponseCode responseCode, String message, Object data){
        this.code = responseCode;
        this.message = message;
        this.data = gson.toJson(data);
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String toJson(){
        return gson.toJson(this);
    }
}
