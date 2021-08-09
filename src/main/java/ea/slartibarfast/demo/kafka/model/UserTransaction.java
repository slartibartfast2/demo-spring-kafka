package ea.slartibarfast.demo.kafka.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserTransaction {

    private Long transactionId;
    private TransactionType transactionType;
    private String username;
}
