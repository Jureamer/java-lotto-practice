package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBallsTest {
    @Test
    @DisplayName("로또 볼을 생성한다")
    void create() {
        LottoBalls lottoBalls = new LottoBalls(1, 2, 3, 4, 5, 6);

        assertThat(lottoBalls.getValues()).containsExactly(
                1, 2, 3, 4, 5, 6
        );
    }
}
