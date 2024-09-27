package yonso.testarchive.java.exception.layered_structure;

class HighLayerClass {

    private final MiddleLayerClass middleLayerClass = new MiddleLayerClass();

    void process() {
        middleLayerClass.process();
    }
}
