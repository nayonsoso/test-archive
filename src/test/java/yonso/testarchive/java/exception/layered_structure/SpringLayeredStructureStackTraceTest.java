package yonso.testarchive.java.exception.layered_structure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("스프링에서 여러 클래스가 계층적으로 있을 때, 스택 트레이스는 어떻게 찍힐까?")
class SpringLayeredStructureStackTraceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    void test1() {
        try {
            String url = "http://localhost:" + port + "/exception";
            restTemplate.getForEntity(url, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
