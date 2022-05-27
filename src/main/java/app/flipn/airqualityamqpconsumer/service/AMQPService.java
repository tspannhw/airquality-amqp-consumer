package app.flipn.airqualityamqpconsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *
 */
@Service
public class AMQPService {
    private static final Logger log = LoggerFactory.getLogger(AMQPService.class);

    @Value("${amqp.topic:amqp-airquality}")
    String topicName;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Component
    public class RabbitMQConsumer {
        @RabbitListener(queues = "${amqp.topic:amqp-airquality}")
        public void receiveMessage(String obs) {

            log.info("Topic Name: {}", topicName);
            log.info("RabbitMQ: {}", obs);
        }
    }
}