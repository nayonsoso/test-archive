package yonso.testarchive.java.exception.checked;

class MiddleLayerException extends Exception {

    MiddleLayerException(Throwable cause) {
        super("MiddleLayerException occurred", cause);
    }

    MiddleLayerException() {
        super("MiddleLayerException occurred");
    }
}
