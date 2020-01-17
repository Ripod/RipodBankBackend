package dbinteraction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Client {
    private String login;
    private String firstName;
    private String secondName;
    private String parentalName;
    private List<Account> accountList = new ArrayList<>();
    private boolean isAuthorized = false;

    public void authorize(String password, Date time){}
    public void requestAccountList(){}
}
