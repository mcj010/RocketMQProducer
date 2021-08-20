import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

public class Consumer2 {

    public static void main(String[] args) throws MQClientException {
       DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test");
       consumer.setNamesrvAddr("127.0.0.1:9876");
       consumer.subscribe("myTopic003","*");
    }
}
