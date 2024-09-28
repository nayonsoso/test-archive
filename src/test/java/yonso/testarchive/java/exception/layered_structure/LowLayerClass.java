package yonso.testarchive.java.exception.layered_structure;

class LowLayerClass {

    void processUncheckedException() {
        throw new RuntimeException("UncheckedException in LowLayerClass");
    }

    void processCheckedException() throws Exception {
        throw new Exception("CheckedException in LowLayerClass");
    }
}
