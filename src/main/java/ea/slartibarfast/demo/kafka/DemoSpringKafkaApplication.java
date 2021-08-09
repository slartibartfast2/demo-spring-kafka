package ea.slartibarfast.demo.kafka;

import ea.slartibarfast.demo.kafka.model.TransactionType;
import ea.slartibarfast.demo.kafka.model.UserTransaction;
import ea.slartibarfast.demo.kafka.service.UserTransactionProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoSpringKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringKafkaApplication.class, args);
    }

}
