package yonso.testarchive.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("start 와 run 함수의 차이 - 2")
class ThreadTest2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("thread name : " + this.getName());
            /*
            * this.getName() 과 Thread.currentThread().getName() 의 차이
            * - this.getName() 은 쓰레드 인스턴스의 이름을 반환하고
            * - Thread.currentThread().getName() 은 현재 실행중인 쓰레드의 이름을 반환한다.
            * 아래 출력에서 ThreadTest1 과 같이, 'Test worker' 가 출력되지 않는 이유는,
            * ThreadTest1에서는 Thread.currentThread()를 사용해서 현재 쓰레드 이름을 출력했고,
            * ThreadTest2에서는 'run()' 함수가 실행되는 인스턴스 이름을 출력했기 때문이다.
            * 이것은 '쓰레드' 객체가 존재하는 상황이긴 하나, 프로그램 실행 단위인 '쓰레드'가 만들어지는 상황은 아니다.
            * */
        }
    }

    @Test
    @DisplayName("start 함수는 새로운 쓰레드들을 멀티쓰레드로 병렬적으로 실행한다.")
    void test1() {
        for (int i = 0; i < 2; i++) {
            ThreadTest2 thread = new ThreadTest2();
            thread.start();
        }
        // 출력 결과 : 쓰레드가 병렬적으로 실행되어 순서가 뒤죽박죽이다.
    }

    @Test
    @DisplayName("run 함수는 현재 쓰레드에서 순차적으로 실행한다.")
    void test2() {
        for (int i = 0; i < 2; i++) {
            ThreadTest2 thread = new ThreadTest2();
            thread.run();
        }
        // 출력 결과 : 작업이 순차적으로 실행되어 차례대로 10번 / 10번이 출력된다.
    }
}
