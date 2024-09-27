package yonso.testarchive.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TestService {

    private final TestValidator testValidator;

    public void baseMethod() {
        testValidator.baseMethod();
    }
}
