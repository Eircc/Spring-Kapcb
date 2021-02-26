import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <a>Title: DirectRabbitReceiverTwo </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/25-10:08
 */
@Component
@RabbitListener(queues = "")
public class DirectRabbitReceiverTwo {

    private static final Logger log = LoggerFactory.getLogger(DirectRabbitReceiverTwo.class);

    @RabbitHandler
    public void processDirectRabbitReceiveMessage(Map message) {
        log.info("=======This is DirectExchange Two======");
        log.info("receive message from rabbit");
        log.info("The message received from direct is : " + message);
        log.info("=======================================");
    }
}
