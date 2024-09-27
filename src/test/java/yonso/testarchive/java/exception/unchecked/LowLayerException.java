package yonso.testarchive.java.exception.unchecked;

public class LowLayerException extends RuntimeException {

    public LowLayerException() {
        super("LowLayerException occurred");
    }
}
