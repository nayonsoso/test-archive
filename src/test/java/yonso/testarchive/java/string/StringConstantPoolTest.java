package yonso.testarchive.java.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringConstantPoolTest {

    @Test
    @DisplayName("String Constant Pool에 의해서, 값이 같은 문자열 변수는 같은 주소를 공유한다.")
    void test1() {
        String a = "hello";
        String b = "hello";
        String c = new String("hello");

        assertThat(a)
                .isSameAs(b)
                .isNotSameAs(c);
    }
}
