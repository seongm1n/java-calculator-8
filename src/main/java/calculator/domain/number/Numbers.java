package calculator.domain.number;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Number> values;

    public Numbers(List<Number> values) {
        this.values = new ArrayList<>(values);
    }

    public int sum() {
        return values.stream()
                .mapToInt(Number::getValue)
                .sum();
    }
}
