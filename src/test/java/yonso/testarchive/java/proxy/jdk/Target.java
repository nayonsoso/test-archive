package yonso.testarchive.java.proxy.jdk;

public class Target implements CommonInterface {

    @Override
    public void function() {
        System.out.println("Target.function()");
    }
}
