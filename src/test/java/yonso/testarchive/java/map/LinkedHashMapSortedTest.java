package yonso.testarchive.java.map;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinkedHashMapSortedTest {

    @Test
    @DisplayName("LinkedHashMap은 .values() 도 순서가 보장이 된다.")
    void test() {
        Map<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < 100000; i++) {
            map.put(String.valueOf(i), 100000 - i);
        }

        Collection<Integer> values = map.values();
        int i = 100000;
        for (Integer value : values) {
            assertThat(value).isEqualTo(i--);
            System.out.println(value);
        }
    }
}
