package com.andre;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer {

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

        // Criação de um consumidor
        MessageConsumer consumer = session.createConsumer(destination);

        // Recebimento e processamento de mensagens
        Message message = consumer.receive();
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            System.out.println("Mensagem recebida: " + textMessage.getText());
        }

        // Fechamento das conexões
        session.close();
        connection.close();
    }
}