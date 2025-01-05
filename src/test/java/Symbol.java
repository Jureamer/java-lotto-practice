public class Symbol {
    private String value;

    public Symbol(String value) {
        verify(value);
        this.value = value;
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
        return value;
    }

}
