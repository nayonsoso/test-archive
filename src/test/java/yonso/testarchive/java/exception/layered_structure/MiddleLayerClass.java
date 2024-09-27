package yonso.testarchive.java.exception.layered_structure;

class MiddleLayerClass {

    private final LowLayerClass lowLayerClass = new LowLayerClass();

    void process() {
        lowLayerClass.process();
    }
}
