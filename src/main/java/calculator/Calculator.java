package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private static final String DELIMITER = " ";
    private List<Operator> operators = new ArrayList<>();
    private List<Integer> numbers = new ArrayList<>();

    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 문자열입니다.");
        }

        String[] strings = s.split(DELIMITER);

        for (int i = 0; i < strings.length; i++) {
            sectionalize(strings[i], i);
        }

        int result = performCalculation();
        return result;
    }

    private int performCalculation() {
        int result = numbers.get(0);

        for (int i = 0; i < operators.size(); i++) {
            Operator operator = operators.get(i);
            int number = numbers.get(i + 1);
            result = operator.calculate(result, number);
        }

        return result;
    }

    private void sectionalize(String value, int i) {
        if (i % 2 == 0) {
            addToNumbers(value);
        }

        if (i % 2 == 1) {
            addToSymbols(value);
        }
    }

    private void addToSymbols(String value) {
        operators.add(Operator.fromSymbol(value));
    }

    private void addToNumbers(String string) {
        validateStringInt(string);
    }

    private void validateStringInt(String string) {
        int value;
        try {
            value = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }

        if (value < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }

        if (value >= 10) {
            throw new IllegalArgumentException("10 이상은 입력할 수 없습니다.");
        }
        numbers.add(value);
    }
}
