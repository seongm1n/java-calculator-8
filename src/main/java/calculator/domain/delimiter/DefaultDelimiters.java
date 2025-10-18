package calculator.domain.delimiter;

public class DefaultDelimiters implements Delimiter{

    @Override
    public String getPattern() {
        return "[,:]";
    }
}
