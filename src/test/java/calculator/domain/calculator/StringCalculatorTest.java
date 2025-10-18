package calculator.domain.calculator;

import calculator.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    @DisplayName("빈 문자열은 0을 반환한다")
    void emptyStringReturnsZero() {
        // given
        String input = "";

        // when
        int result = calculator.calculate(input);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("쉼표 구분자로 덧셈을 계산한다")
    void calculateWithComma() {
        assertThat(calculator.calculate("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("콜론 구분자로 덧셈을 계산한다")
    void calculateWithColon() {
        assertThat(calculator.calculate("1:2")).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표와 콜론 혼합 구분자로 덧셈을 계산한다")
    void calculateWithMixedDelimiters() {
        assertThat(calculator.calculate("1,2:3")).isEqualTo(6);
    }

    @ParameterizedTest
    @CsvSource({
            "//;\\n1;2;3, 6",
            "//|\\n1|2|3, 6",
            "//*\\n1*2*3, 6"
    })
    @DisplayName("커스텀 구분자로 덧셈을 계산한다")
    void calculateWithCustomDelimiter(String input, int expected) {
        // when
        int result = calculator.calculate(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("음수 입력 시 예외가 발생한다")
    void negativeInputThrowsException() {
        // given
        String input = "1,-2,3";

        // when & then
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining("음수");
    }
}
