import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private static final String DELIMITER = " ";
    private List<Symbol> symbols = new ArrayList<>();
    private List<Integer> numbers = new ArrayList<>();


    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 문자열입니다.");
        }

        String[] strings = s.split(DELIMITER);

        for (int i = 0; i < strings.length; i++) {
            sectionalize(strings[i], i);
        }

        int result = realCalculate();
        return result;
    }

    private int realCalculate() {
        int result = numbers.get(0);

        for (int i = 0; i < symbols.size(); i++) {
            String operator = symbols.get(i).getValue();
            int number = numbers.get(i + 1);

            switch (operator) {
                case "+":
                    result = add(result, number);
                    break;
                case "-":
                    result = minus(result, number);
                    break;
                case "*":
                    result = multiple(result, number);
                    break;
                case "/":
                    result = divide(result, number);
                    break;
                default:
                    throw new IllegalArgumentException("사칙 연산 기호가 아닙니다.");
            }
        }

        return result;
    }

    private void sectionalize(String string, int i) {
        if (i % 2 == 0) {
            int value = Integer.parseInt(string);
            if (value < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }

            if (value >= 10) {
                throw new IllegalArgumentException("10 이상은 입력할 수 없습니다.");
            }
            numbers.add(value);
        }

        if (i % 2 == 1) {
            symbols.add(new Symbol(string));
        }
    }

    private int multiple(int a, int b) {
        return a * b;
    }

    private int minus(int a, int b) {
        return a - b;
    }

    private int add(int a, int b) {
        return a + b;
    }

    private int divide(int a, int b) {
        return a / b;
    }
}
