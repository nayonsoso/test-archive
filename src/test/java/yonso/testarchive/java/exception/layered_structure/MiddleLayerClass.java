package yonso.testarchive.java.exception.layered_structure;

class MiddleLayerClass {

    private final LowLayerClass lowLayerClass = new LowLayerClass();

    void processUncheckedException() {
        lowLayerClass.processUncheckedException();
    }

    void processCheckedException() throws Exception {
        lowLayerClass.processCheckedException();
    }
}
