package task;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@RestController
public class Controller {
    Queue<String> users = new ConcurrentLinkedQueue<>();

    @PostMapping("/users")
    public void addUser(@RequestParam String name) {
        users.add(name);
    }

    @GetMapping("/users")
    public Queue<String> getUsers() {
        return users;
    }
}
