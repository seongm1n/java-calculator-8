package calculator.domain.parser;

import calculator.domain.number.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputParserTest {

    private final InputParser parser = new InputParser();

    @Test
    @DisplayName("기본 구분자로 문자열을 파싱한다")
    void parseWithDefaultDelimiters() {
        // given
        String input = "1,2,3";

        // when
        Numbers numbers = parser.parse(input);

        // then
        assertThat(numbers.sum()).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자로 문자열을 파싱한다")
    void parseWithCustomDelimiter() {
        // given
        String input = "//;\\n1;2;3";

        // when
        Numbers numbers = parser.parse(input);

        // then
        assertThat(numbers.sum()).isEqualTo(6);
    }

    @Test
    @DisplayName("쉼표와 콜론이 혼합된 문자열을 파싱한다")
    void parseWithMixedDefaultDelimiters() {
        // given
        String input = "1,2:3";

        // when
        Numbers numbers = parser.parse(input);

        // then
        assertThat(numbers.sum()).isEqualTo(6);
    }

    @Test
    @DisplayName("빈 문자열을 파싱하면 0을 반환한다")
    void parseEmptyString() {
        // given
        String input = "";

        // when
        Numbers numbers = parser.parse(input);

        // then
        assertThat(numbers.sum()).isEqualTo(0);
    }

    @Test
    @DisplayName("다양한 커스텀 구분자로 파싱한다")
    void parseWithVariousCustomDelimiters() {
        // given
        String input1 = "//|\\n1|2|3";
        String input2 = "//*\\n1*2*3";

        // when
        Numbers numbers1 = parser.parse(input1);
        Numbers numbers2 = parser.parse(input2);

        // then
        assertThat(numbers1.sum()).isEqualTo(6);
        assertThat(numbers2.sum()).isEqualTo(6);
    }
}
