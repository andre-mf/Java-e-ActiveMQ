package com.andre;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.time.LocalDateTime;

public class Producer {

    public static void main(String[] args) throws JMSException {

        // Conexão com o ActiveMQ
        String brokerUrl = "tcp://localhost:61616";
        String username = "artemis";
        String password = "artemis";
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(username, password, brokerUrl);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        // Criação de uma sessão
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Criação de uma fila de destino
        Destination destination = session.createQueue("QUEUE.NAME");

        // Criação de um produtor
        MessageProducer producer = session.createProducer(destination);

        // Criação e envio de uma mensagem
        String textMessage = "Teste MSG - Virando Programador - " + LocalDateTime.now().toString();
        TextMessage message = session.createTextMessage(textMessage);
        producer.send(message);
        System.out.println(textMessage);

        // Fechamento das conexões
        session.close();
        connection.close();
    }
}
