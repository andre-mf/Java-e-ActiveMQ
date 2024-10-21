package com.andre.activemq;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private final JmsTemplate jmsTemplate;

    public Producer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String destination, Person person) {
        jmsTemplate.convertAndSend(destination, person);
//        System.out.println("Mensagem enviada: " + person.toString());
    }
}
