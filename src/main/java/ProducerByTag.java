import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.ArrayList;

public class ProducerByTag {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        // set group
        DefaultMQProducer producer = new DefaultMQProducer("test");

        // set ip
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        System.out.println("ProducerByTag start...");

        Message msg = new Message("myTopicTag", "TAG-B", "send TAG-B".getBytes());
        msg.setKeys("key1");
        SendResult sendResult = producer.send(msg);
        System.out.println(sendResult);
        producer.shutdown();
        System.out.println("ProducerByTag shutdown");
    }
}
