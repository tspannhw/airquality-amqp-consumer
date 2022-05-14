package app.flipn.airqualityamqpconsumer;

import app.flipn.airqualityamqpconsumer.config.AMQPConfig;
import app.flipn.airqualityamqpconsumer.service.AMQPService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(
		classes = {
				AMQPConfig.class,
				AMQPService.class
		}
)
class AirQualityAMQPConsumerApplicationTests {

	@Autowired
	AMQPService amqpService;

	@Test
	void contextLoads() {
	}
}