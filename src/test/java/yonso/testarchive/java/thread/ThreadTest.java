package yonso.testarchive.java.thread;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("start 와 run 함수의 차이 - 1")
class ThreadTest extends Thread {

    @Override
    public void run() {
        System.out.println("thread name : " + Thread.currentThread().getName());
    }

    @Test
    @DisplayName("start 함수를 한번 이상 호출할 수 없다. 여러번 호출하려하면 예외가 발생한다.")
    void test0() {
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();

        assertThatCode(threadTest::start)
                .isInstanceOf(IllegalThreadStateException.class);
    }

    @Test
    @DisplayName("start 함수는 새로운 쓰레드를 만들고 run 함수를 호출한다.")
    void test1() {
        System.out.println("thread name : " + Thread.currentThread().getName());
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new ThreadTest();
            threads[i].start();
        }

        /* 출력 결과
        thread name : Test worker
        thread name : Thread-4
        thread name : Thread-5
        thread name : Thread-6
        thread name : Thread-7
        thread name : Thread-8
        */
    }

    @Test
    @DisplayName("run 함수는 새로운 쓰레드를 만들지 않고, 현재 쓰레드의 run 함수를 호출한다.")
    void test2() {
        System.out.println("thread name : " + Thread.currentThread().getName());
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new ThreadTest();
            threads[i].run();
        }

        /* 출력 결과
        thread name : Test worker
        thread name : Test worker
        thread name : Test worker
        thread name : Test worker
        thread name : Test worker
        thread name : Test worker
        */
    }
}
