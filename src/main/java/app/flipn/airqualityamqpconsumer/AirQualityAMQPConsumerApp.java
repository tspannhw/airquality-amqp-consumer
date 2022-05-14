package app.flipn.airqualityamqpconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirQualityAMQPConsumerApp implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(AirQualityAMQPConsumerApp.class);

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(AirQualityAMQPConsumerApp.class, args);
	}

	@Override
	public void run(String... args) {
	}
}
