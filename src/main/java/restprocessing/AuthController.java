package restprocessing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import restutils.responses.AuthResponse;

@RestController
public class AuthController {
    @GetMapping("login.do")
    public AuthResponse loginDo(@RequestParam("login") String login, @RequestParam("hashedPass") String hashedPass){
        return new AuthResponse(0, "Success", true);
    }
}
