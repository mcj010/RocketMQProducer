import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author lucy
 */
public class Consumer1 {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test");//1 .设置group

        consumer.setNamesrvAddr("127.0.0.1:9876");// 设置IP

        consumer.subscribe("myTopic001", "*");// 设置topic

        //设置监听
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            //实现
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {

                for (MessageExt msg : msgs) {
                    System.out.println(new String(msg.getBody()));
                }
                // 默认情况下 这条消息只会被 一个consumer 消费到 点对点
                // message 状态修改
                // ack
               // return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        // 启动
        consumer.start();;
        System.out.println("Consumer 01 start...");
    }
}
