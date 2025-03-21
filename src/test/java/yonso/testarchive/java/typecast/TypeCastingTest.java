package yonso.testarchive.java.typecast;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TypeCastingTest {

    @Test
    @DisplayName("null 을 타입캐스팅하면 어떻게 되는가?")
    void test() {
        assertThatCode(() -> castNull(null)).doesNotThrowAnyException();

    }

    void castNull(Object obj) {
        String str = (String) obj;
        System.out.println(str);
    }
}
