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
    private String login;
    private String firstName;
    private String secondName;
    private String parentalName;
    private List<Account> accountList = new ArrayList<>();
    private boolean isAuthorized = false;
    String token;
    LocalDateTime tokenValidUntil;

    public void authorize(String password, Date time) {
    }

    public void requestAccountList() {
    }

    public String generateToken() {

        LocalDateTime currentTime = LocalDateTime.now();
        int salt = (int) (Math.random() * 1000);
        String initialString = login + currentTime.toString() + Integer.toString(salt);
        String generatedToken = DigestUtils.md5DigestAsHex(initialString.getBytes());
        this.token = generatedToken;
        tokenValidUntil = currentTime.plusMinutes(15);
        return generatedToken;
    }
}
