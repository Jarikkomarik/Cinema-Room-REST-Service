package task;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.*;


@RestController
public class Controller {
    Map<Integer, String> map = new ConcurrentHashMap<>();

    @GetMapping("/api/data/{id}")
    public Map<String, String> getData(@PathVariable int id) {
        return Map.of("data", map.get(id));
    }

    @PostMapping("/api/data/new")
    public Map<String, Integer> returnId (@RequestBody Popka popka) {
        Random r = new Random();
        int rand = r.nextInt();
        while (map.containsKey(rand) == true) {
            rand = r.nextInt();
        }
        map.put(rand, popka.getData());
        return Map.of("id", rand);
    }

}
class Popka {
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
