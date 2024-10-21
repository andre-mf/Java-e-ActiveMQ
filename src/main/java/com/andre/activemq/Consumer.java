package com.andre.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "minhaFila")
    public void receiveMessage(Person person) {
        System.out.println("Mensagem recebida: " + person);
    }
}
