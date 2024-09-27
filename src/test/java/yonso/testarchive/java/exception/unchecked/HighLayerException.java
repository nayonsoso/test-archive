package yonso.testarchive.java.exception.unchecked;

public class HighLayerException extends RuntimeException {

    public HighLayerException(Throwable cause) {
        super("HighLayerException occurred", cause);
    }

    public HighLayerException() {
        super("HighLayerException occurred");
    }
}
