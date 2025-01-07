package lotto;

import lotto.domain.LottoBalls;
import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @Test
    @DisplayName("로또 번호를 6개 생성한다")
    void generate() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoBalls lottoBalls = lottoGenerator.generate();

        assertThat(lottoBalls.getValues()).hasSize(6);
    }

    @Test

}
