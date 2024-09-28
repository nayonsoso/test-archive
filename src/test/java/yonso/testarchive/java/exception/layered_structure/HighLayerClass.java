package yonso.testarchive.java.exception.layered_structure;

class HighLayerClass {

    private final MiddleLayerClass middleLayerClass = new MiddleLayerClass();

    void processUncheckedException() {
        middleLayerClass.processUncheckedException();
    }

    void processCheckedException() throws Exception {
        middleLayerClass.processCheckedException();
    }
}
