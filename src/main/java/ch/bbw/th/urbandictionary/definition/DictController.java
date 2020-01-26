package ch.bbw.th.urbandictionary.definition;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DictController {


    @GetMapping("/lookup")
    public String sendForm(DefinitionList definition) {

        return "lookup";
    }

    @PostMapping("/lookup")
    public String processForm(DefinitionList definition) {

        return "showdefinition";
    }
}
