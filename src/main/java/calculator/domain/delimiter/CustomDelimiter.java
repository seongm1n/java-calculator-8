package calculator.domain.delimiter;

import java.util.regex.Pattern;

public class CustomDelimiter implements Delimiter {
    private final String delimiter;

    public CustomDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public String getPattern() {
        return Pattern.quote(delimiter);
    }
}
