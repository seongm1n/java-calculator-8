package calculator.domain.parser;

import calculator.domain.delimiter.CustomDelimiter;
import calculator.exception.InvalidInputException;

import java.util.Optional;

public class DelimiterExtractor {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    public Optional<CustomDelimiter> extract(String input) {
        if (!hasCustomDelimiter(input)) {
            return Optional.empty();
        }

        String delimiterChar = extractDelimiterChar(input);
        return Optional.of(new CustomDelimiter(delimiterChar));
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private String extractDelimiterChar(String input) {
        int start = CUSTOM_DELIMITER_PREFIX.length();
        int end = input.indexOf(CUSTOM_DELIMITER_SUFFIX);

        if (end == -1) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
        }
        if (end == start) {
            throw new InvalidInputException("구분자는 비어있을 수 없습니다.");
        }

        return input.substring(start, end);
    }

    public String removeDelimiterPrefix(String input) {
        int delimiterEndIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        return input.substring(delimiterEndIndex + CUSTOM_DELIMITER_SUFFIX.length());
    }
}
