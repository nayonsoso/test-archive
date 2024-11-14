package yonso.testarchive.jpa.transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import yonso.testarchive.util.OutputTestExtension;

@SpringBootTest
@ExtendWith(OutputTestExtension.class)
class TransactionalTestServiceTest {

    @SpyBean
    private TransactionalTestService transactionalTestService;

    @Test
    @DisplayName("프록시(주입되는 빈)의 transactional 함수를 호출하면, 트랜잭션이 생성된다.")
    void testTransactionFunction(OutputTestExtension outputTestExtension) {
        transactionalTestService.transactionFunction();

        String actual = outputTestExtension.getAndPrintOutput();
        String expect = "innerFunction's transaction = "
                + "yonso.testarchive.jpa.transactional.TransactionalTestService.transactionFunction";

        assertThat(actual).contains(expect);
    }

    @Test
    @DisplayName("transactional 이 아닌 함수에서 같은 클래스의 transactional 함수를 호출하면, 트랜잭션이 적용되지 않는다.")
    void test(OutputTestExtension outputTestExtension) {
        transactionalTestService.justFunction();

        String actual = outputTestExtension.getAndPrintOutput();
        String expect = "innerFunction's transaction = null";

        verify(transactionalTestService, times(1)).transactionFunction();
        assertThat(actual).contains(expect);
        // transactional 이 붙은 함수를 호출하더라도, 그것이 프록시 객체에서 호출하는 것이 아니라 함수에서 함수로의 호출히기 때문에
        // 새로운 트랜잭션이 만들어지지 않는다.
    }
}
