package ch.bbw.th.urbandictionary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DictController {


    @GetMapping("/lookup")
    public String sendForm(Definition definition) {

        return "lookup";
    }

    @PostMapping("/lookup")
    public String processForm(Definition definition) {

        return "showdefinition";
    }
}
