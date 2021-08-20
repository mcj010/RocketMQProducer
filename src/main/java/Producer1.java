import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.ArrayList;

public class Producer1 {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        // set group
        DefaultMQProducer producer = new DefaultMQProducer("test");

        // set ip
        producer.setNamesrvAddr("127.0.0.1:9876");

        // start
        producer.start();
        System.out.println("Producer1 01 start...");

        // set topic and message
        Message msg1 = new Message("myTopic001","test1".getBytes());
        Message msg2 = new Message("myTopic001","test2".getBytes());
        Message msg3 = new Message("myTopic001","test3".getBytes());
        Message msg4 = new Message("myTopic001", "test4".getBytes());

        ArrayList<Message> list = new ArrayList<Message>();
        list.add(msg1);
        list.add(msg2);
        list.add(msg3);
        list.add(msg4);

        SendResult sendResult = producer.send(list);
        System.out.println(sendResult);
        producer.shutdown();
        System.out.println("Consumer01 shutdown");

    }
}
