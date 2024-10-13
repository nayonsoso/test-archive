package yonso.testarchive.java.proxy.pattern;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import yonso.testarchive.util.OutputTestExtension;

@ExtendWith(OutputTestExtension.class)
@DisplayName("프록시 패턴 테스트")
class ProxyPatternTest {

    @DisplayName("프록시 패턴을 사용한 경우, 결과가 어떻게 나오는지 확인해보자.")
    @Test
    void test(OutputTestExtension outputTestExtension) {
        Client client = new Client();

        client.run();

        String output = outputTestExtension.getAndPrintOutput();
        String expected = """
                Proxy.function() before Target.function()
                Target.function()
                Proxy.function() after Target.function()
                """;
        assertThat(output).contains(expected);
    }
}
