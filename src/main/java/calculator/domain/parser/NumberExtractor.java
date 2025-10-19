package calculator.domain.parser;

import calculator.domain.delimiter.Delimiter;
import calculator.domain.number.Numbers;
import calculator.domain.number.Number;
import calculator.exception.InvalidInputException;

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
                .map(this::parseNumber)
                .map(Number::new)
                .toList();

        return new Numbers(numbers);
    }

    private int parseNumber(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("숫자가 아닌 값이 입력되었습니다 : " + token);
        }
    }
}
