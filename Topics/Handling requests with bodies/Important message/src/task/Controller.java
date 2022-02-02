package task;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @PostMapping("/message")
    public void setMessage(@RequestBody Message message){
        Message.getMessage().setImportantMessage(message.getImportantMessage());
    }

    @GetMapping("/message")
    public Message getMessage(){
        return Message.getMessage();
    }

}

class Message {
    private String importantMessage;
    private static Message message = new Message();
    private Message(){}

    public String getImportantMessage() {
        return importantMessage;
    }

    public void setImportantMessage(String importantMessage) {
        this.importantMessage = importantMessage;
    }

    public static Message getMessage() {
        return message;
    }

}