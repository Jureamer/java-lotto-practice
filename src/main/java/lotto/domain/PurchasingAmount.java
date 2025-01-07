package lotto.domain;

public class PurchasingAmount {
    private int value;
    public static final int MIN_AMOUNT = 1000;

    public PurchasingAmount(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_AMOUNT) {
            throw new IllegalArgumentException("로또 구매 금액은 " + MIN_AMOUNT + "원 이상이어야 합니다.");
        }

        if (value % MIN_AMOUNT != 0) {
            throw new IllegalArgumentException("로또 구매 금액은 " + MIN_AMOUNT + "원의 배수여야 합니다.");
        }
    }


    public int getAmount() {
        return value;
    }

    public void pay() {
        value -= MIN_AMOUNT;
    }

    public boolean canBuy() {
        return value >= MIN_AMOUNT;
    }

}
