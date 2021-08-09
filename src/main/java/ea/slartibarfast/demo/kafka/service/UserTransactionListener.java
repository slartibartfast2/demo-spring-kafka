package ea.slartibarfast.demo.kafka.service;

import ea.slartibarfast.demo.kafka.model.UserTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserTransactionListener {

    @KafkaListener(topics = "users.transactions", groupId = "user-trx-group", containerFactory = "userTransactionKafkaListenerContainerFactory")
    @SendTo(value = "users.transactions.processed")
    public String processUserTransaction(UserTransaction userTransaction) {
        log.info("ListenAndReply [{}]", userTransaction);
        return Long.toString(userTransaction.getTransactionId());
    }
}
