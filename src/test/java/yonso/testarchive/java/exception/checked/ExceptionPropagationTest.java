package yonso.testarchive.java.exception.checked;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Checked Exception 의 전파에 대해 알아보자")
class ExceptionPropagationTest {

    @Test
    @DisplayName("cause 를 사용한 CheckedException 의 스택 트레이스를 확인해보자")
    void test1() {
        ExceptionChainingWithCause exceptionChaining = new ExceptionChainingWithCause();

        try {
            exceptionChaining.processHighLayerLogic();
        } catch (HighLayerException e) {
            e.printStackTrace();
        }
        // HighLayerException -> MiddleLayerException -> LowLayerException 의 스택이 찍혀있다
        // 새롭게 알게된 것 : Checked vs Unchecked Exception 은 스택 트레이스에서는 차이가 나지 않는다.
    }

    @Test
    @DisplayName("cause 를 사용하지 않은 CheckedException 의 스택 트레이스를 확인해보자")
    void test2() {
        ExceptionChainingWithoutCause exceptionChaining = new ExceptionChainingWithoutCause();

        try {
            exceptionChaining.processHighLayerLogic();
        } catch (HighLayerException e) {
            e.printStackTrace();
        }
        // HighLayerException 에 대한 스택만 찍혀있다
    }
}
