package yonso.testarchive.spring;

import org.springframework.stereotype.Component;

@Component
public class TestValidator {

    public void baseMethod() {
        throw new RuntimeException("TestValidator 에서 발생한 예외");
    }
}
