package calculator.domain.calculator;

import calculator.domain.number.Numbers;
import calculator.domain.parser.InputParser;

public class StringCalculator {
    private final InputParser parser;

    public StringCalculator() {
        this.parser = new InputParser();
    }

    public int calculate(String input) {
        Numbers numbers = parser.parse(input);
        return numbers.sum();
    }
}
