package dbinteraction;

import org.springframework.util.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Client {
    public String getLogin() {
        return login;
    }

    private String login;
    private String firstName;
    private String secondName;
    private String parentalName;
    private List<Account> accountList = new ArrayList<>();
    private boolean isAuthorized;
    private String token;
    private LocalDateTime tokenValidUntil;

    public Client(String login, boolean isAuthorized) {
        this.login = login;
        this.isAuthorized = isAuthorized;
        tokenValidUntil = LocalDateTime.now();
        System.out.println("client created login: " + login);
    }

    public void authorize(String password, Date time) {
    }

    public List<Account> requestAccountList() {
        //BD request
        accountList.clear();
        accountList.add(new Account("11111111111111111111" + login, 1000.10f));
        accountList.add(new Account("22222222222222222222" + login, 2000.20f));
        return accountList;
    }

    public String getToken() {
        System.out.println("get token");
        LocalDateTime checkTime = LocalDateTime.now();
        if (checkTime.isAfter(tokenValidUntil)) {
            System.out.println("check time failed" + tokenValidUntil.toString() + "  " + checkTime.toString());
            generateToken();
        }
        System.out.println("returned token: " + this.token + "valid until: " + tokenValidUntil.toString());
        return this.token;
    }

    private void generateToken() {
        LocalDateTime currentTime = LocalDateTime.now();
        int salt = (int) (Math.random() * 1000);
        String initialString = login + currentTime.toString() + salt;
        this.token = DigestUtils.md5DigestAsHex(initialString.getBytes());
        tokenValidUntil = currentTime.plusMinutes(15);
    }

    public boolean validateToken(String incomingToken) {
        String checkToken = getToken();
        System.out.println("validating token: " + incomingToken + "check token: " + checkToken);
        return incomingToken.equals(checkToken);
    }

}
