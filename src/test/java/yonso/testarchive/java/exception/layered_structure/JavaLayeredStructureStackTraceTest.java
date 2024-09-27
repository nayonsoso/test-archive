package yonso.testarchive.java.exception.layered_structure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자바에서 여러 클래스가 계층적으로 있을 때, 스택 트레이스는 어떻게 찍힐까?")
class JavaLayeredStructureStackTraceTest {

    @Test
    void test1() {
        HighLayerClass highLayerClass = new HighLayerClass();

        try {
            highLayerClass.process();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
