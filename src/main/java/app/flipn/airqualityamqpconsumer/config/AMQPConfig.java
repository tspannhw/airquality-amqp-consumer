package app.flipn.airqualityamqpconsumer.config;

import app.flipn.airqualityamqpconsumer.service.AMQPService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@Configuration
public class AMQPConfig {
    private static final Logger log = LoggerFactory.getLogger(AMQPConfig.class);

    @Value("${amqp.server:pulsar1}")
    String serverName;

    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory ccf = new CachingConnectionFactory();
        log.info("Server name {}", serverName);
        ccf.setAddresses(serverName);
        return ccf;
    }

    @Bean
    public RabbitAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        log.info("Rabbit mq created");
        return rabbitTemplate;
    }

    @Bean
    public Queue myQueue() {
        return new Queue("amqp-airquality");
    }
}