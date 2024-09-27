package yonso.testarchive.java.exception.layered_structure;

class LowLayerClass {

    void process() {
        throw new RuntimeException("LowLayerClass에서 발생한 예외");
    }
}
