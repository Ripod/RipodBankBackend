package restprocessing;

import dbinteraction.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import restutils.responses.AuthResponse;

import java.util.function.Predicate;

import static restprocessing.Util.storage;


@RestController
public class AuthController {
    @GetMapping("login.do")
    public AuthResponse loginDo(@RequestParam("login") String login){
        Client tempUser = new Client(login, true);
        Predicate<Client> predicate = o -> o.getLogin().equals(login);
        if(storage.stream().noneMatch(predicate)){
            storage.add(tempUser);
        }
        String token = storage.stream().filter(predicate).findFirst().get().getToken();
        return new AuthResponse(0, token, true);
    }
}
