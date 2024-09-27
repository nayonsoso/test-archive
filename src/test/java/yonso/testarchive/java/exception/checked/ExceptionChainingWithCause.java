package yonso.testarchive.java.exception.checked;

class ExceptionChainingWithCause {

    public void processHighLayerLogic() throws HighLayerException {
        try {
            processMiddleLayerLogic();
        } catch (MiddleLayerException e) {
            throw new HighLayerException(e);
        }
    }

    private void processMiddleLayerLogic() throws MiddleLayerException {
        try {
            processLowLayerLogic();
        } catch (LowLayerException e) {
            throw new MiddleLayerException(e);
        }
    }

    public void processLowLayerLogic() throws LowLayerException {
        throw new LowLayerException();
    }
}
