package yonso.testarchive.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class TestController {

    private final TestService testService;

    @GetMapping("/")
    public void baseMethod() {
        testService.baseMethod();
    }
}