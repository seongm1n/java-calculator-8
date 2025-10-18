package calculator.domain.parser;

import calculator.domain.delimiter.Delimiter;
import calculator.domain.number.Numbers;
import calculator.domain.number.Number;

import java.util.Arrays;
import java.util.List;

public class NumberExtractor {
    public Numbers extract(String input, Delimiter delimiter) {
        if (input.isEmpty()) {
            return new Numbers(List.of());
        }

        String[] tokens = input.split(delimiter.getPattern());
        List<Number> numbers = Arrays.stream(tokens)
                .map(String::trim)
                .map(Integer::parseInt)
                .map(Number::new)
                .toList();

        return new Numbers(numbers);
    }
}
