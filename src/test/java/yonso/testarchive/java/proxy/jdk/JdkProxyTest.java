package yonso.testarchive.java.proxy.jdk;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Proxy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import yonso.testarchive.util.OutputTestExtension;

@DisplayName("jdk 프록시 테스트")
@ExtendWith(OutputTestExtension.class)
public class JdkProxyTest {

    @Test
    @DisplayName("동적 프록시의 결과 확인")
    void test2(OutputTestExtension outputTestExtension) {
        CommonInterface commonInterface = new Target();
        CommonInterface dynamicProxy = (CommonInterface) Proxy.newProxyInstance(
                CommonInterface.class.getClassLoader(),
                new Class<?>[]{CommonInterface.class},
                new LoggingInvocationHandler(commonInterface)
        );
        dynamicProxy.function();

        String actual = outputTestExtension.getAndPrintOutput();
        String expect = """
                DynamicProxy.invoke() before invoke target.method()
                Target.function()
                DynamicProxy.invoke() after invoke target.method()
                """;
        assertThat(actual).isEqualTo(expect);
    }
}
