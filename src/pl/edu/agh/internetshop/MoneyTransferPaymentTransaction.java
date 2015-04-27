package pl.edu.agh.internetshop;


import java.util.UUID;

public interface MoneyTransferPaymentTransaction extends PaymentMethod {
    boolean validate(MoneyTransfer transfer);
    boolean commit(MoneyTransfer transfer);
}
