package yonso.testarchive.java.exception.layered_structure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Checked, Unchecked의 스택 트레이스를 비교해보자")
class CheckedUncheckedStackTraceTest {

    @Test
    void test1() {
        HighLayerClass highLayerClass = new HighLayerClass();

        try {
            highLayerClass.processUncheckedException();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test2() {
        HighLayerClass highLayerClass = new HighLayerClass();

        try {
            highLayerClass.processCheckedException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
