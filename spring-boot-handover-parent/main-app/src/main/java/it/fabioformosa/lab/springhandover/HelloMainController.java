package it.fabioformosa.lab.springhandover;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloMainController {

    @RequestMapping("/handover")
    String handover() {
        return "Handover completed!";
    }

    @RequestMapping("/")
    String hello() {
        return "Hello World by Main App!";
    }

}
