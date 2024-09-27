package yonso.testarchive.java.exception.unchecked;

public class MiddleLayerException extends RuntimeException {

    public MiddleLayerException(Throwable cause) {
        super("MiddleLayerException occurred", cause);
    }

    public MiddleLayerException() {
        super("MiddleLayerException occurred");
    }
}
