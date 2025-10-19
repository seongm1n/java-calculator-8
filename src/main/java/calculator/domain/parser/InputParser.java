package calculator.domain.parser;

import calculator.domain.delimiter.CustomDelimiter;
import calculator.domain.delimiter.DefaultDelimiters;
import calculator.domain.delimiter.Delimiter;
import calculator.domain.number.Numbers;

import java.util.Optional;

public class InputParser {
    private static final Delimiter DEFAULT_DELIMITER = new DefaultDelimiters();
    private final DelimiterExtractor delimiterExtractor;
    private final NumberExtractor numberExtractor;

    public InputParser() {
        this.delimiterExtractor = new DelimiterExtractor();
        this.numberExtractor = new NumberExtractor();
    }

    public Numbers parse(String input) {
        Optional<CustomDelimiter> customDelimiter = delimiterExtractor.extract(input);

        if (customDelimiter.isPresent()) {
            String numberPart = delimiterExtractor.removeDelimiterPrefix(input);
            return numberExtractor.extract(numberPart, customDelimiter.get());
        }

        return numberExtractor.extract(input, DEFAULT_DELIMITER);
    }
}
