package yonso.testarchive.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ExceptionHandlerTestController {

    private final TestService testService;

    @GetMapping("/handler-exception-resolver-exception")
    public void throwHandlerExceptionResolverException() {
        testService.throwException();
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleNoSuchElementFoundException(RuntimeException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
