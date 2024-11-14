package yonso.testarchive.jpa.transactional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class TransactionalTestService {

    public void justFunction() {
        transactionFunction();
    }

    @Transactional
    public void transactionFunction() {
        String name = TransactionSynchronizationManager.getCurrentTransactionName();
        System.out.println("innerFunction's transaction = " + name);
    }
}
