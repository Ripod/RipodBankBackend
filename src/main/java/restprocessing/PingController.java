package restprocessing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import restutils.responses.BaseResponse;

@RestController
public class PingController {

    private static final String template = "Hello, %s!";

    @GetMapping("/ping")
    public BaseResponse ping (@RequestParam(value = "name", defaultValue = "User") String name){
        return new BaseResponse(0, String.format(template, name));
    }
}
