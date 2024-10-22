package com.andre.activemq;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivemqController {

    private final Producer producer;
    private final PersonService personService;

    public ActivemqController(Producer producer, PersonService personService) {
        this.producer = producer;
        this.personService = personService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody Person person) {
        producer.sendMessage("minhaFila", person);
        return "Mensagem enviada: " + person.toString();
    }

    @GetMapping()
    public ResponseEntity<Page<Person>> findAll(Pageable pageable) {
        return ResponseEntity.ok(personService.findAll(pageable));
    }
}