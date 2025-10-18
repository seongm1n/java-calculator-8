package calculator.view;

public class OutputView {
    private static final String RESULT_FORMAT = "결과 : %d";

    public void printResult(int result) {
        System.out.println(String.format(RESULT_FORMAT, result));
    }

    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}
