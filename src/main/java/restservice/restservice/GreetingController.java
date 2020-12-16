package restservice.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

// Like a route in NODE

@RestController
public class GreetingController {

    private static final String template = "hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // /greeting?name=Ben will print name
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
