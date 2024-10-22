package com.andre.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private final PersonService personService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Consumer(PersonService personService) {
        this.personService = personService;
    }

    @JmsListener(destination = "minhaFila")
    public void receiveMessage(Person person) {
        logger.info("Mensagem recebida: " + person);
        personService.save(person);
    }
}
