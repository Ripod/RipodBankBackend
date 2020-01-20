package restutils.responses;

public class AuthResponse extends BaseResponse{

    boolean isAuthorized;

    public boolean getAuthorized() {
        return isAuthorized;
    }

    public AuthResponse(int code, String message, boolean isAuthorized){
        super(code, message);
        this.isAuthorized = isAuthorized;
    }

}
