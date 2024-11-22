package ase.group10.cicdtest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

    // GET method
    @GetMapping("/hello")
    public String helloGet(@RequestParam(defaultValue = "World") String name) {
        return "GET: Hello, " + name + "!";
    }

    @GetMapping("/fuck")
    public String fuckGet(@RequestParam(defaultValue = "World") String name) {
        return "GET: fuck, " + name + "!";
    }

    // POST method
    @PostMapping("/hello")
    public String helloPost(@RequestBody(required = false) String name) {
        if (name == null || name.isEmpty()) {
            name = "Kate";
        }
        return "POST: Greetings, " + name + "!";
    }
}
