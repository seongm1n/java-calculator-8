package calculator.domain.delimiter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CustomDelimiterTest {

    @Test
    @DisplayName("커스텀 구분자로 문자열을 분리할 수 있다")
    void customDelimiterSplit() {
        // given
        CustomDelimiter delimiter = new CustomDelimiter(";");
        String input = "1;2;3";

        // when
        String[] result = input.split(delimiter.getPattern());

        // then
        assertThat(result).containsExactly("1", "2", "3");
    }

    @ParameterizedTest
    @ValueSource(strings = {";", "|", "*", "."})
    @DisplayName("다양한 특수문자를 커스텀 구분자로 사용할 수 있다")
    void variousCustomDelimiters(String delimiterChar) {
        // given
        CustomDelimiter delimiter = new CustomDelimiter(delimiterChar);
        String input = "1" + delimiterChar + "2" + delimiterChar + "3";

        // when
        String[] result = input.split(delimiter.getPattern());

        // then
        assertThat(result).containsExactly("1", "2", "3");
    }
}
