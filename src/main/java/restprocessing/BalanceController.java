package restprocessing;

import dbinteraction.Client;
import org.graalvm.compiler.replacements.aarch64.AArch64StringUTF16Substitutions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import restutils.responses.BalanceResponse;
import restutils.responses.BaseResponse;

import java.util.Optional;
import java.util.function.Predicate;

import static restprocessing.Util.storage;


@RestController
public class BalanceController {

    @GetMapping("accounts")
    public BaseResponse getAccounts(@RequestParam("token") String token) {
        Predicate<Client> predicate = o -> o.validateToken(token);
        Optional<Client> optionalClient = storage.stream().filter(predicate).findFirst();
        if(optionalClient.isPresent()){
            return new BalanceResponse(0, "success", optionalClient.get().requestAccountList());
        }else{
            return new BaseResponse(2, "Session not found");
        }
    }
}
