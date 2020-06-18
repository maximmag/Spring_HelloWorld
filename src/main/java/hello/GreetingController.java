package hello;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private int count = 1;
    ArrayList<Greeting> arr = new ArrayList<Greeting>();


    @RequestMapping("/greeting")
    public ArrayList<Greeting> greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
            arr.add( new Greeting(counter.incrementAndGet(),
                    String.format(template, name)));
            return arr;
    }

}

