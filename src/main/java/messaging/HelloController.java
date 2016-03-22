package messaging;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/Hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }





}