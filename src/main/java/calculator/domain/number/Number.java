package calculator.domain.number;

import calculator.exception.InvalidInputException;

public class Number {
    private final int value;

    public Number(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < 0) {
            throw new InvalidInputException("음수는 허용되지 않습니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
