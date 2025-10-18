package calculator.domain.parser;

import calculator.domain.delimiter.CustomDelimiter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class DelimiterExtractorTest {

    private final DelimiterExtractor extractor = new DelimiterExtractor();

    @Test
    @DisplayName("커스텀 구분자를 추출한다")
    void extractCustomDelimiter() {
        // given
        String input = "//;\\n1;2;3";

        // when
        Optional<CustomDelimiter> result = extractor.extract(input);

        // then
        assertThat(result).isPresent();
        assertThat(result.get().getPattern()).contains(";");
    }

    @Test
    @DisplayName("커스텀 구분자가 없으면 Optional.empty를 반환한다")
    void extractNoCustomDelimiter() {
        // given
        String input = "1,2,3";

        // when
        Optional<CustomDelimiter> result = extractor.extract(input);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("커스텀 구분자 접두사를 제거하고 숫자 부분만 반환한다")
    void removeDelimiterPrefix() {
        // given
        String input = "//;\\n1;2;3";

        // when
        String result = extractor.removeDelimiterPrefix(input);

        // then
        assertThat(result).isEqualTo("1;2;3");
    }

    @Test
    @DisplayName("다양한 커스텀 구분자를 추출할 수 있다")
    void extractVariousCustomDelimiters() {
        // given
        String input = "//|\\n1|2|3";

        // when
        Optional<CustomDelimiter> result = extractor.extract(input);

        // then
        assertThat(result).isPresent();
        assertThat(result.get().getPattern()).contains("|");
    }
}
