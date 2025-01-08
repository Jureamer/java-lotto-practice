package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    private static Stream<Arguments> provideWinningNumbers() {
        return Stream.of(Arguments.of("1,2,3,4,5,6", 6),
                Arguments.of("1,2,3,4,5,7", 5),
                Arguments.of("1,2,3,4,7,8", 4),
                Arguments.of("1,2,3,7,8,9", 3),
                Arguments.of("1,2,7,8,9,10", 2),
                Arguments.of("1,7,8,9,10,11", 1),
                Arguments.of("7,8,9,10,11,12", 0));
    }

    @Test
    void 로또_당첨번호를_생성한다() {
        assertThat(new WinningLotto("1,2,3,4,5,6")).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "1,2,3,4,5,0"})
    void 로또_번호_범위를_초과하면_예외를_반환한다(String s) {
        assertThatThrownBy(() -> new WinningLotto(s))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이여야 합니다.");
    }

    @Test
    void 로또_번호_중복이_있으면_예외를_반환한다() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호에 중복이 있습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void 로또_번호가_6개가_아니면_예외를_반환한다(String s) {
        assertThatThrownBy(() -> new WinningLotto(s))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개여야 합니다.");
    }

    @Test
    void 로또_당첨번호를_출력한다() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");
        assertThat(winningLotto.toString()).isEqualTo("1, 2, 3, 4, 5, 6");
    }

    @ParameterizedTest
    @MethodSource("provideWinningNumbers")
    void 로또_당첨번호_맞은_개수를_반환한다(String winningNumbers, int expected) {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");
        Lotto lotto = new Lotto(winningNumbers);
        assertThat(winningLotto.match(lotto)).isEqualTo(expected);
    }
}
