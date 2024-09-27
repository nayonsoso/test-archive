package yonso.testarchive.java.exception.unchecked;

public class ExceptionChainingWithCause {

    public void processHighLayerLogic() {
        try {
            processMiddleLayerLogic();
        } catch (MiddleLayerException e) {
            throw new HighLayerException(e);
        }
    }

    public void processMiddleLayerLogic() {
        try {
            processLowLayerLogic();
        } catch (LowLayerException e) {
            throw new MiddleLayerException(e);
        }
    }

    public void processLowLayerLogic() {
        throw new LowLayerException();
    }
}
