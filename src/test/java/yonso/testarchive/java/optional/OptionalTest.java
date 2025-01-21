package yonso.testarchive.java.optional;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OptionalTest {

    @Test
    @DisplayName("Optional.of() 의 인자가 null 이면 NPE 가 발생한다.")
    void test() {
        // given
        String hi = null;

        // when & then
        assertThatCode(() -> Optional.of(hi)).isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("Optional.ofNullable() 의 인자는 null 이어도 NPE 가 발생하지 않는다.")
    void test2() {
        // given
        String hi = null;

        // when & then
        assertThatCode(() -> Optional.ofNullable(hi)).doesNotThrowAnyException();
    }
}
