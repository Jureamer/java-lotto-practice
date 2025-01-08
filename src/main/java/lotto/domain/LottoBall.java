package lotto.domain;

public class LottoBall {
    private final int LOW_BOUND = 1;
    private final int HIGH_BOUND = 45;
    private final int value;

    public LottoBall(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < LOW_BOUND || value > HIGH_BOUND) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이여야 합니다.");
        }
    }

    public int getNumber() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBall lottoBall = (LottoBall) o;
        return value == lottoBall.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }
}
