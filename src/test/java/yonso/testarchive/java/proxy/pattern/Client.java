package yonso.testarchive.java.proxy.pattern;

public class Client {

    private final CommonInterface instance = new Proxy();

    public void run() {
        instance.function();
    }
}
