package org.example.appone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/getHelloPass")
    public String getHelloMessagePass() {
        return helloService.fetchHelloMessagePass();
    }
    @GetMapping("/getHelloFail")
    public String getHelloMessageFail() {
        return helloService.fetchHelloMessageFail();
    }
}
