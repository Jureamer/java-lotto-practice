package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchasingAmountTest {
    @Test
    @DisplayName("로또 구매 금액을 생성한다")
    void create() {
        PurchasingAmount purchasingAmount = new PurchasingAmount(14000);
        assertThat(purchasingAmount.getAmount()).isEqualTo(14000);
    }

    @Test
    @DisplayName("로또 구매 금액이 1000원 미만일 경우 예외를 던진다")
    void lessThan1000() {
        assertThatThrownBy(() -> new PurchasingAmount(999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구매 금액은 1000원 이상이어야 합니다.");
    }

    @Test
    @DisplayName("로또 구매 금액이 1000원의 배수가 아닐 경우 예외를 던진다")
    void notMultipleOf1000() {
        assertThatThrownBy(() -> new PurchasingAmount(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구매 금액은 1000원의 배수여야 합니다.");
    }
}
