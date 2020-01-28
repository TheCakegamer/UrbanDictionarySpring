package ch.bbw.th.urbandictionary.response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller("/lookup")
public class ResponseController {
    @GetMapping("/lookup")
    public String sendForm(Response response) {

        return "lookup";
    }

    @PostMapping("/lookup")
    public String processForm(Response response) {

        return "showdefinition";
    }
}

