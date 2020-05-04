package restutils.responses;

import dbinteraction.Account;

import java.util.List;
import java.util.Map;

public class BalanceResponse extends BaseResponse{
    public List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public BalanceResponse (int code, String message, List<Account> accounts){
        super(code, message);
        this.accounts = accounts;
    }

}
