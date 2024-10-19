package yonso.testarchive.java.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingInvocationHandler implements InvocationHandler {

    private final Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("DynamicProxy.invoke() before invoke target.method()");
        Object result = method.invoke(target, args);
        System.out.println("DynamicProxy.invoke() after invoke target.method()");
        return result;
    }

    // 위 코드에서 method.invoke(proxy, args) 가 아니라 target 를 사용한 이유 :
    // 1) 프록시는 '프록시 객체'가 아니라 '실제 객체'의 method 를 호출해야 한다.
    // 2) method.invoke(proxy, args) 를 했다면, 내부적으로 다시 LoggingInvocationHandler 의 invoke 를 호출할 것이므로 무한 재귀가 걸린다.
}
