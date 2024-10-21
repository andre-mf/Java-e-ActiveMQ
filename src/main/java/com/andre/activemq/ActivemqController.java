package com.andre.activemq;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivemqController {

    private final Producer producer;

    public ActivemqController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody Person person) {
        producer.sendMessage("minhaFila", person);
        return "Mensagem enviada: " + person.toString();
    }
}
