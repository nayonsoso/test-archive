package yonso.testarchive.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;

public class OutputTestExtension implements BeforeEachCallback, ParameterResolver {

    PrintStream original;
    ByteArrayOutputStream outputStream;

    public String getAndPrintOutput() {
        System.setOut(this.original);
        System.out.println(this.outputStream.toString());
        return this.outputStream.toString();
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        this.original = System.out;
        this.outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return parameterContext.getParameter().getType() == OutputTestExtension.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return this;
    }
}
