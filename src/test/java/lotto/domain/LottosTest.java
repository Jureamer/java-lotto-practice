package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void 로또를_여러_장_구매한다() {
        PurchasingAmount purchasingAmount = new PurchasingAmount(14000);
        LottoGenerator lottoGenerator = new LottoGenerator();

        Lottos lottos = new Lottos(purchasingAmount, lottoGenerator);
        assertThat(lottos.getLottos()).hasSize(14);
    }
}
