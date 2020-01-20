package restutils.responses;

import java.util.Map;

public class BalanceResponse extends BaseResponse{
    public Map<String, Float> accounts;

    public Map<String, Float> getAccounts() {
        return accounts;
    }

    public BalanceResponse (int code, String message, Map<String, Float> accounts){
        super(code, message);
        this.accounts = accounts;
    }

}
