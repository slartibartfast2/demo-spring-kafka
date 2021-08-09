package ea.slartibarfast.demo.kafka.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic userTransactionTopic() {
        return TopicBuilder.name("users.transactions").partitions(3).build();
    }

    @Bean
    public NewTopic processedTransactionTopic() {
        return TopicBuilder.name("users.transactions.processed").partitions(1).build();
    }
}
