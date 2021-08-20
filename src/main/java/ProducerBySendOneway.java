import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

// 单向
public class ProducerBySendOneway {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException {
        // set group
        DefaultMQProducer producer = new DefaultMQProducer("test");

        // set ip
        producer.setNamesrvAddr("127.0.0.1:9876");

        // start
        producer.start();
        System.out.println("ProducerBySendOneway start...");

        Message message = new Message("myTopic001", "send one way".getBytes());
        producer.sendOneway(message);
        producer.shutdown();
        System.out.println("ProducerBySendOneway shutdown");
    }

}
