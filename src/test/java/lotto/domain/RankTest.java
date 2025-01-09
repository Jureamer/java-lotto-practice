package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    private static Stream<Arguments> provideWinningNumbers() {
        return Stream.of(Arguments.of(6, false, 2_000_000_000),
                Arguments.of(5, true, 30_000_000),
                Arguments.of(5, false, 1_500_000),
                Arguments.of(4, false, 50_000),
                Arguments.of(3, false, 5_000),
                Arguments.of(3, true, 5_000),
                Arguments.of(2, false, 0),
                Arguments.of(2, true, 0),
                Arguments.of(1, false, 0),
                Arguments.of(1, true, 0),
                Arguments.of(0, false, 0),
                Arguments.of(0, true, 0));

    }

    @Test
    void 로또_등수를_생성한다() {
        assertThat(Rank.valueOf(3, false)).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("provideWinningNumbers")
    void 로또_당첨_금액을_가져온다(int countOfMatch, boolean matchBonus, int winningMoney) {
        assertThat(Rank.valueOf(countOfMatch, matchBonus).getWinningMoney()).isEqualTo(winningMoney);
    }
}
