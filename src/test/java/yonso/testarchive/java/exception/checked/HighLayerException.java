package yonso.testarchive.java.exception.checked;

class HighLayerException extends Exception {

    HighLayerException(Throwable cause) {
        super("HighLayerException occurred", cause);
    }

    HighLayerException() {
        super("HighLayerException occurred");
    }
}
