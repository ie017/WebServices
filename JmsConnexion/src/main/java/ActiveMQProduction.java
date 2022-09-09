import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ActiveMQProduction {
    public static void main(String[] args) throws JMSException{
        //Create ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");/* Il existe plusieurs protocoles qui sont supportés par ActiveMQ : (TCP, AMQP
        (Developer principalement pour faire la communication asynchrone entre les apps sous forme d'un tableau des objects), STOMP (
        Developer aussi pour la communication asy, mais les messages sont de format text (peut etre utiliser pour developer des apps de chat)), MQTT
        (meme chose pour échanger des messages, mais pour les apps de IOT))*/

        //Create connection
        Connection connection = connectionFactory.createConnection();
        connection.start();

        //Create session from our object connection
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        // Create destination (Topic or Queue)
        Destination destination = session.createTopic("MyTopic");

        //Create Message Producer from session to teh topic
        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT); /* Une fois que tu vas délivrer
        le message tu le supprimes, c'est une manière pour dire au broker tu n'as pas le droit
        de garder les messages chez toi une fois qu'ils sont consommés */

        //Create message
        String text = "ie017 was here";
        TextMessage message = session.createTextMessage(text); /* Il existe plusieurs types de messages JMS
        TextMessage, BytesMessage (images,..), MapMessage(key-value), ObjectMessage (Message qui contient
        un objet java), StreamMessage (Pour envoi un flux de données qui prendre beaucoup de temps (ex : signal audio, signal video, ...))*/

        //Send message
        producer.send(message);
        //Clean up
        session.close();
        connection.close();
    }
}
