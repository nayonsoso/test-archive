package yonso.testarchive.java.proxy.pattern;

public class Target implements CommonInterface {

    @Override
    public void function() {
        System.out.println("Target.function()");
    }
}
