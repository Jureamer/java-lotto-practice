package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @Test
    @DisplayName("로또 번호를 6개 생성한다")
    void generate() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto lottoBalls = lottoGenerator.generate();
        assertThat(lottoBalls.getValues()).hasSize(6);
    }
}
