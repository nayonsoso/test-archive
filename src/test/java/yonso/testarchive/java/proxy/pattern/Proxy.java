package yonso.testarchive.java.proxy.pattern;

public class Proxy implements CommonInterface {

    private final Target target;

    public Proxy() {
        this.target = new Target();
    }

    @Override
    public void function() {
        System.out.println("Proxy.function() before Target.function()");
        target.function();
        System.out.println("Proxy.function() after Target.function()");
    }
}
