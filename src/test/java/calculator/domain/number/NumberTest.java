package calculator.domain.number;

import calculator.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @Test
    @DisplayName("양수로 Number 객체를 생성한다")
    void createPositiveNumber() {
        // given & when
        Number number = new Number(5);

        // then
        assertThat(number.getValue()).isEqualTo(5);
    }

    @Test
    @DisplayName("0으로 Number 객체를 생성한다")
    void createZero() {
        // given & when
        Number number = new Number(0);

        // then
        assertThat(number.getValue()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -100})
    @DisplayName("음수로 Number 객체 생성 시 예외가 발생한다")
    void createNegativeNumberThrowsException(int value) {
        // when & then
        assertThatThrownBy(() -> new Number(value))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining("음수");
    }
}
