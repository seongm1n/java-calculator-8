package calculator.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @Test
    @DisplayName("여러 숫자의 합을 계산한다")
    void calculateSum() {
        // given
        Numbers numbers = new Numbers(List.of(
                new Number(1),
                new Number(2),
                new Number(3)
        ));

        // when
        int result = numbers.sum();

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("빈 숫자 리스트의 합은 0이다")
    void emptyListSumIsZero() {
        // given
        Numbers numbers = new Numbers(List.of());

        // when
        int result = numbers.sum();

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("단일 숫자의 합을 계산한다")
    void singleNumberSum() {
        // given
        Numbers numbers = new Numbers(List.of(new Number(10)));

        // when
        int result = numbers.sum();

        // then
        assertThat(result).isEqualTo(10);
    }
}
