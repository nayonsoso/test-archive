package yonso.testarchive.spring;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import jakarta.servlet.ServletException;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("스프링에서 예외를 던질 때, 어떤 흐름을 따르는지 확인하자")
class SpringExceptionFlowTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @SpyBean
    private BasicErrorController basicErrorController;

    @SpyBean
    private DispatcherServlet dispatcherServlet;

    @LocalServerPort
    private int port;

    /*
     WAS(톰캣) -> 필터 -> 서블릿(디스패처 서블릿) -> 인터셉터 -> 컨트롤러
     -> 컨트롤러(예외발생) -> 인터셉터 -> 서블릿(디스패처 서블릿) -> 필터 -> WAS(톰캣)
     -> WAS(톰캣) -> 필터 -> 서블릿(디스패처 서블릿) -> 인터셉터 -> 컨트롤러(BasicErrorController)
     */
    @DisplayName("기본적인 흐름")
    @Test
    void test1() throws ServletException, IOException {
        String url = "http://localhost:" + port + "/basic-controller-exception";
        restTemplate.getForEntity(url, String.class);

        verify(dispatcherServlet, times(2)).service(any(), any());
        verify(basicErrorController, times(1)).error(any());
    }

    /*
    HandlerExceptionResolver 에서 처리되고, 디스패처 서블릿까지 가지 않는다.
     */
    @DisplayName("@ExceptionHandler 으로 처리할 때의 흐름")
    @Test
    void test2() throws ServletException, IOException {
        String url = "http://localhost:" + port + "/handler-exception-resolver-exception";
        restTemplate.getForEntity(url, String.class);

        verify(dispatcherServlet, times(1)).service(any(), any());
        verify(basicErrorController, times(0)).error(any());
    }
}
