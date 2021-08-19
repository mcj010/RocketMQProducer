import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.ArrayList;

public class Producer1 {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("test");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        Message msg1 = new Message("myTopic001","test1".getBytes());
        Message msg2 = new Message("myTopic001","test2".getBytes());
        Message msg3 = new Message("myTopic001","test3".getBytes());

        ArrayList<Message> list = new ArrayList<Message>();
        list.add(msg1);
        list.add(msg2);
        list.add(msg3);

        SendResult sendResult3 = producer.send(msg1);
        System.out.println(sendResult3);
//        producer.shutdown();
//        System.out.println("已经停机");

    }
}
