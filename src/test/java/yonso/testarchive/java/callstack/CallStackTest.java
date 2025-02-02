package yonso.testarchive.java.callstack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CallStackTest {

    @Test
    @DisplayName("자바의 호출 스택에서는 원시값 / 객체를 어떻게 관리하는가?")
    void test() {
        int[] arr = new int[1];
        arr[0] = 99;
        testRecursive(arr, 0);
        // 원시값은 호출스택에 값 자체가 저장되기 때문에 보존되지만,
        // 객체는 메모리 힙 주소를 넘겨주기 때문에 값 변경이 이전 호출스택까지 반영된다.
        // call by value!
    }

    void testRecursive(int[] arr, int depth) {
        if (depth == 1) {
            arr[0]++;
            System.out.println("다음 단계에서 원시값 : " + depth);
            System.out.println("다음 단계에서 객체의 주소 : " + arr);
            System.out.println("다음 단계에서 객체의 값 : " + arr[0]);
            return;
        }

        System.out.println("현재 단계에서 원시값 : " + depth);
        System.out.println("현재 단계에서 객체의 주소 : " + arr);
        System.out.println("현재 단계에서 객체의 값 : " + arr[0]);

        testRecursive(arr, depth + 1);

        System.out.println("현재 단계로 돌아온 후...");
        System.out.println("현재 단계에서 원시값 : " + depth);
        System.out.println("현재 단계에서 객체의 주소 : " + arr);
        System.out.println("현재 단계에서 객체의 값 : " + arr[0]);
    }
}
