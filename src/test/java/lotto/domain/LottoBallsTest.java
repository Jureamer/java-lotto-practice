package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBallsTest {
    @Test
    void 로또_볼을_생성한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.getValues()).containsExactly(
                1, 2, 3, 4, 5, 6
        );
    }

    @Test
    void 로또_문자열을_출력한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.toString()).isEqualTo("1, 2, 3, 4, 5, 6");
    }

}
