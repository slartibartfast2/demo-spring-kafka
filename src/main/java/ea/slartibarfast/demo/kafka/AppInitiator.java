package ea.slartibarfast.demo.kafka;

import ea.slartibarfast.demo.kafka.model.TransactionType;
import ea.slartibarfast.demo.kafka.model.UserTransaction;
import ea.slartibarfast.demo.kafka.service.UserTransactionProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AppInitiator {

    private final UserTransactionProducer userTransactionProducer;

    @EventListener
    public void initiateKafka(ApplicationReadyEvent event) throws InterruptedException {
        Thread.sleep(5000);
        UserTransaction userLoginTrx = UserTransaction.builder()
                                                 .transactionId(1L)
                                                 .username("slartibarfast")
                                                 .transactionType(TransactionType.LOGIN)
                                                 .build();

        userTransactionProducer.sendMessage(userLoginTrx);

        Thread.sleep(3000);

        UserTransaction userAddToBasketTrx1 = UserTransaction.builder()
                                                      .transactionId(2L)
                                                      .username("slartibarfast")
                                                      .transactionType(TransactionType.ADD_TO_BASKET)
                                                      .build();

        userTransactionProducer.sendMessage(userAddToBasketTrx1);

        UserTransaction userAddToBasketTrx2 = UserTransaction.builder()
                                                             .transactionId(3L)
                                                             .username("slartibarfast")
                                                             .transactionType(TransactionType.ADD_TO_BASKET)
                                                             .build();

        Thread.sleep(4000);

        userTransactionProducer.sendMessage(userAddToBasketTrx2);

        UserTransaction userCheckoutTrx = UserTransaction.builder()
                                                      .transactionId(4L)
                                                      .username("slartibarfast")
                                                      .transactionType(TransactionType.CHECKOUT)
                                                      .build();

        userTransactionProducer.sendMessage(userCheckoutTrx);

        Thread.sleep(5000);

        UserTransaction userLogoutTrx = UserTransaction.builder()
                                                      .transactionId(5L)
                                                      .username("slartibarfast")
                                                      .transactionType(TransactionType.LOGOUT)
                                                      .build();

        userTransactionProducer.sendMessage(userLogoutTrx);
    }
}
