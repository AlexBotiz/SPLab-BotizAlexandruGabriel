package labexample.controllers;

import labexample.ClientComponent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public record ClientController(ClientComponent clientComponent) {

    @GetMapping("/hello-client")
    public String hello() {
        return "Hello from ClientComponent = " + clientComponent;
    }
}
