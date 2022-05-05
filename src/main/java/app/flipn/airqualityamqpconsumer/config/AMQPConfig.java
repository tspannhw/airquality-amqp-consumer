package app.flipn.airqualityamqpconsumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@Configuration
public class AMQPConfig {

    @Value("${amqp.server:pulsar1}")
    String serverName;

    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory ccf = new CachingConnectionFactory();
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
        return rabbitTemplate;
    }

    @Bean
    public Queue myQueue() {
        return new Queue("myqueue");
    }
}