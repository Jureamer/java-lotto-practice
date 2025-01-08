package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    private static Stream<Arguments> provideWinningNumbers() {
        return Stream.of(Arguments.of("1,2,3,4,5,6", 2_000_000_000),
                Arguments.of("1,2,3,4,5,7", 30_000_000),
                Arguments.of("1,2,3,4,7,8", 1_500_000),
                Arguments.of("1,2,3,7,8,9", 50_000),
                Arguments.of("1,2,7,8,9,10", 5_000),
                Arguments.of("1,7,8,9,10,11", 0),
                Arguments.of("7,8,9,10,11,12", 0));
    }

    @Test
    void 로또_등수를_생성한다() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");
        Rank rank = Rank.valueOf(winningLotto.match(lotto));
        assertThat(rank).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("provideWinningNumbers")
    void 로또_당첨_금액을_가져온다(String lottoNumbers, int winningMoney) {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        WinningLotto winningLotto = new WinningLotto(lottoNumbers);
        Rank rank = Rank.valueOf(winningLotto.match(lotto));
        assertThat(rank.getWinningMoney()).isEqualTo(winningMoney);
    }
}
