package yonso.testarchive.java.exception.unchecked;

public class ExceptionChainingWithoutCause {

    public void processHighLayerLogic() {
        try {
            processMiddleLayerLogic();
        } catch (MiddleLayerException e) {
            throw new HighLayerException();
        }
    }

    public void processMiddleLayerLogic() {
        try {
            processLowLayerLogic();
        } catch (LowLayerException e) {
            throw new MiddleLayerException();
        }
    }

    public void processLowLayerLogic() {
        throw new LowLayerException();
    }
}
