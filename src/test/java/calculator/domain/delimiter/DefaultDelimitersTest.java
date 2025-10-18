package calculator.domain.delimiter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultDelimitersTest {

    @Test
    @DisplayName("기본 구분자 패턴은 쉼표와 콜론을 포함한다")
    void defaultDelimiterPattern() {
        // given
        DefaultDelimiters delimiters = new DefaultDelimiters();

        // when
        String pattern = delimiters.getPattern();

        // then
        assertThat(pattern).isEqualTo("[,:]");
    }

    @Test
    @DisplayName("쉼표로 문자열을 분리할 수 있다")
    void splitByComma() {
        // given
        DefaultDelimiters delimiters = new DefaultDelimiters();
        String input = "1,2,3";

        // when
        String[] result = input.split(delimiters.getPattern());

        // then
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("콜론으로 문자열을 분리할 수 있다")
    void splitByColon() {
        // given
        DefaultDelimiters delimiters = new DefaultDelimiters();
        String input = "1:2:3";

        // when
        String[] result = input.split(delimiters.getPattern());

        // then
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("쉼표와 콜론이 혼합된 문자열을 분리할 수 있다")
    void splitByMixedDelimiters() {
        // given
        DefaultDelimiters delimiters = new DefaultDelimiters();
        String input = "1,2:3";

        // when
        String[] result = input.split(delimiters.getPattern());

        // then
        assertThat(result).containsExactly("1", "2", "3");
    }
}
