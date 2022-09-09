import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ActiveMQConsumption {
    public static void main(String[] args) throws JMSException {

        //Create ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        //Create connection
        Connection connection = connectionFactory.createConnection();

        //Create session from our object connection
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        // Create destination (Topic or Queue)
        Destination destination = session.createTopic("MyTopic");

        //Create Message Producer from session to teh topic
        MessageConsumer consumer = session.createConsumer(destination);

        //Start Connection
        connection.start();

        //Create JMS listener from messages
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                try {
                   if (message instanceof TextMessage){
                      TextMessage textMessage = (TextMessage) message;
                      String text = textMessage.getText();
                      System.out.println("200 OK : "+ text);
                     } else {
                       System.out.println("200 OK : "+ message);
                     }
                   }catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        //Clean up
        connection.close();


    }
}
