package calculator;

public enum Operator {
    plus("+") {
        @Override
        public int calculate(int x, int y) {
            return x + y;
        }
    },
    minus("-") {
        @Override
        public int calculate(int x, int y) {
            return x - y;
        }
    },
    mutiple("*") {
        @Override
        public int calculate(int x, int y) {
            return x * y;
        }
    },
    divide("/") {
        @Override
        public int calculate(int x, int y) {
            if (y == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return x / y;
        }
    };

    public abstract int calculate(int x, int y);

    private final String symbol;

    Operator(String symbol) {
        verify(symbol);
        this.symbol = symbol;
    }

    public static Operator fromSymbol(String symbol) {
        for (Operator operator : Operator.values()) {
            if (operator.symbol.equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("사칙 연산 기호가 아닙니다.");
    }

    private void verify(String value) {

        if (value.length() != 1) {
            throw new IllegalArgumentException("사칙 연산 기호는 한 글자여야 합니다.");
        }

        if (!value.matches("[+\\-*/]")) {
            throw new IllegalArgumentException("사칙 연산 기호가 아닙니다.");
        }
    }

    public String getValue() {
        return symbol;
    }

}
