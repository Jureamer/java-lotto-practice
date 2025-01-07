package lotto.domain;

import lotto.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    @DisplayName("로또를 생성한다.")
    void createLottos() {
        PurchasingAmount purchasingAmount = new PurchasingAmount(14000);
        LottoGenerator lottoGenerator = new LottoGenerator();

        Lottos lottos = new Lottos(purchasingAmount, lottoGenerator);
        assertThat(lottos.getLottos()).hasSize(14);
    }
}
