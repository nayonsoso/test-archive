package yonso.testarchive.java.proxy.pattern;

public class Proxy implements CommonInterface {

    private final Traget traget;

    public Proxy() {
        this.traget = new Traget();
    }

    @Override
    public void function() {
        System.out.println("Proxy.function() before Target.function()");
        traget.function();
        System.out.println("Proxy.function() after Target.function()");
    }
}
