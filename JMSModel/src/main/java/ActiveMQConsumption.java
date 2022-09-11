import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ActiveMQConsumption {
    public static void main(String[] args) throws JMSException {

        //Create ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        //Create connection
        Connection connection = connectionFactory.createConnection();

        //Start Connection
        connection.start();

        //Create session from our object connection
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Create destination (Topic or Queue)
        Destination destination = session.createQueue("MyQueue");

        //Create Message Producer from session to teh topic
        MessageConsumer consumer = session.createConsumer(destination);

        /* On peut aussi utiliser ce code pour recevoir le message, mais en manière synchrone
        Message message = consumer.receive();
        if (message instanceof TextMessage) {

            TextMessage textMessage = (TextMessage) message;
            System.out.println("200 OK : " + textMessage.getText());
        }*/

        //Create JMS listener from messages pour le consommer à manière asynchrone
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    String text;
                    try {
                        text = textMessage.getText();
                        System.out.println("200 OK : " + text);
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("200 OK : " + message);
                }
            }
        });

        //Clean up
        connection.close();


    }
}
