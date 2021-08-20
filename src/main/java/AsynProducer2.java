import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;


// 异步
public class AsynProducer2 {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException {

        DefaultMQProducer producer = new DefaultMQProducer("test");

        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        System.out.println("Producer02 start...");

        Message message = new Message("myTopic001", "asyn send".getBytes());

        producer.send(message, new SendCallback() {
            public void onSuccess(SendResult sendResult) {
                System.out.println("消息发送成功");
                System.out.println("sendResult:" + sendResult);
            }

            public void onException(Throwable e) {
                e.printStackTrace();
                System.out.println("发送异常");
            }
        });
        // producer.shutdown();
        System.out.println("Producer02 shutdown");
    }
}
