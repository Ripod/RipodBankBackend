package restutils.responses;

public class BaseResponse {

    private int code;
    private String message;

    public BaseResponse(){
    }
    public BaseResponse(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
