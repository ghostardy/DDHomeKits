package family.dd.DDHomeKits.AuthCenter.domain;

import com.google.gson.Gson;
import family.dd.DDHomeKits.AuthCenter.definition.ResponseCode;

public class ServiceResponseDTO {
    private int code= ResponseCode.HANDLING.getCodeValue();
    private String message="handling";
    private String data="{}";
    private Gson gson;

    public ServiceResponseDTO() {}
    public ServiceResponseDTO(ResponseCode responseCode, String message, Object data){
        this.code = responseCode.getCodeValue();
        this.message = message;
        this.data = gson.toJson(data);
    }

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
        return gson.toJson(this);
    }
}
