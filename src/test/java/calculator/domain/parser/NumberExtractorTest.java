package calculator.domain.parser;

import calculator.domain.delimiter.CustomDelimiter;
import calculator.domain.delimiter.DefaultDelimiters;
import calculator.domain.number.Numbers;
import calculator.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberExtractorTest {

    private final NumberExtractor extractor = new NumberExtractor();

    @Test
    @DisplayName("기본 구분자로 숫자를 추출한다")
    void extractNumbersWithDefaultDelimiters() {
        // given
        String input = "1,2,3";
        DefaultDelimiters delimiter = new DefaultDelimiters();

        // when
        Numbers numbers = extractor.extract(input, delimiter);

        // then
        assertThat(numbers.sum()).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자로 숫자를 추출한다")
    void extractNumbersWithCustomDelimiter() {
        // given
        String input = "1;2;3";
        CustomDelimiter delimiter = new CustomDelimiter(";");

        // when
        Numbers numbers = extractor.extract(input, delimiter);

        // then
        assertThat(numbers.sum()).isEqualTo(6);
    }

    @Test
    @DisplayName("빈 문자열은 빈 Numbers를 반환한다")
    void extractFromEmptyString() {
        // given
        String input = "";
        DefaultDelimiters delimiter = new DefaultDelimiters();

        // when
        Numbers numbers = extractor.extract(input, delimiter);

        // then
        assertThat(numbers.sum()).isEqualTo(0);
    }

    @Test
    @DisplayName("음수가 포함된 경우 예외가 발생한다")
    void extractNegativeNumberThrowsException() {
        // given
        String input = "1,-2,3";
        DefaultDelimiters delimiter = new DefaultDelimiters();

        // when & then
        assertThatThrownBy(() -> extractor.extract(input, delimiter))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining("음수");
    }
}
