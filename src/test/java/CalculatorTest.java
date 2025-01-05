import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("문자열을 덧셈한다")
    void testAdd() {
        int result = calculator.calculate("4 + 5");
        assertThat(result).isEqualTo(9);
    }

    @Test
    @DisplayName("문자열을 뺄셈한다")
    void testMinus() {
        int result = calculator.calculate("3 - 2");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("문자열을 곱셈한다")
    void testMultiple() {
        int result = calculator.calculate("1 * 2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("문자열을 나눗셈한다")
    void testDivide() {
        int result = calculator.calculate("6 / 2");
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("입력 값이 숫자가 아닐 때 예외를 던진다")
    @ValueSource(strings = {"1 + a", "1 + b", "1 + c", "1 + d"})
    void testInvalidNumber(String input) {
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 값이 입력되었습니다.");
    }

    @ParameterizedTest
    @DisplayName("입력 값이 null이거나 빈 문자열일 때 예외를 던진다")
    @NullAndEmptySource
    void testException(String input) {
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값이 null이거나 빈 문자열입니다.");
    }

    @ParameterizedTest
    @DisplayName("사칙 연산 기호가 한 글자 이상일 경우 예외를 던진다")
    @ValueSource(strings = {"1 +- 2", "1 -+ 2", "1 */ 2", "1 /* 2"})
    void testInvalidSymbol(String input) {
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사칙 연산 기호는 한 글자여야 합니다.");
    }


    @ParameterizedTest
    @DisplayName("사칙 연산 기호가 아닐 경우 예외를 던진다")
    @ValueSource(strings = {"1 % 2", "1 ^ 2", "1 # 2", "1 & 2"})
    void testInvalidOperator(String input) {
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사칙 연산 기호가 아닙니다.");
    }

    @ParameterizedTest
    @DisplayName("0으로 나누었을 때 예외를 던진다")
    @ValueSource(strings = {"1 / 0", "2 / 0", "3 / 0", "4 / 0"})
    void testDivideByZero(String input) {
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("/ by zero");
    }

    @ParameterizedTest
    @DisplayName("10 이상의 숫자를 입력했을 때 예외를 던진다")
    @ValueSource(strings = {"10 + 2", "3 + 12", "15 / 5"})
    void testWithOverTen(String input) {
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("10 이상은 입력할 수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("음수를 입력했을 때 예외를 던진다")
    @ValueSource(strings = {"-1 + 2", "3 - -2", "-3 * 2", "1 / -2"})
    void testWithNegativeNumber(String input) {
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수는 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("2개 이상의 기호가 있는 사칙연산을 수행한다.")
    void testMultipleOperations() {
        int result = calculator.calculate("3 * 3 - 3 / 2");
        assertThat(result).isEqualTo(3);
    }
}
