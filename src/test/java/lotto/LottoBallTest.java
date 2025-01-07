package lotto;

import lotto.domain.LottoBall;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBallTest {
    @Test
    @DisplayName("로또 번호를 생성한다")
    void create() {
        LottoBall lottoBall = new LottoBall(1);
        assertThat(lottoBall.getNumber()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("로또 번호가 범위를 초과하면 예외를 던진다")
    @ValueSource(ints = {0, 46})
    void outOfRange(int input) {
        assertThatThrownBy(() -> new LottoBall(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이여야 합니다.");
    }
}
