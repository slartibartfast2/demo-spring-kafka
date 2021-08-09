package ea.slartibarfast.demo.kafka.service;

import ea.slartibarfast.demo.kafka.model.UserTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserTransactionProducer {

    private final KafkaTemplate<Long, UserTransaction> userTransactionKafkaTemplate;

    public void sendMessage(UserTransaction userTransaction) {
        userTransactionKafkaTemplate.sendDefault(userTransaction.getTransactionId(), userTransaction);
    }
}
