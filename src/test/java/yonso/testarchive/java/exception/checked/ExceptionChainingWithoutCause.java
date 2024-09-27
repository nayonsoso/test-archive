package yonso.testarchive.java.exception.checked;

class ExceptionChainingWithoutCause {

    public void processHighLayerLogic() throws HighLayerException {
        try {
            processMiddleLayerLogic();
        } catch (MiddleLayerException e) {
            throw new HighLayerException();
        }
    }

    private void processMiddleLayerLogic() throws MiddleLayerException {
        try {
            processLowLayerLogic();
        } catch (LowLayerException e) {
            throw new MiddleLayerException();
        }
    }

    public void processLowLayerLogic() throws LowLayerException {
        throw new LowLayerException();
    }
}
