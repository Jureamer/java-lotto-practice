package lotto.domain;

public class WinningLotto extends Lotto {
    private LottoBall bonusBall;

    public WinningLotto(String s, String bonusNumber) {
        this(s, Integer.parseInt(bonusNumber));
    }

    public WinningLotto(String s, int bonusNumber) {
        super(s);
        LottoBall bonusBall = new LottoBall(bonusNumber);
        validatebonusNumber(bonusBall);
        this.bonusBall = bonusBall;
    }

    private void validatebonusNumber(LottoBall bonusNumber) {
        if (lottoBalls.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public int match(Lotto lotto) {
        return (int) lotto.getValues().stream()
                .filter(getValues()::contains)
                .count();
    }
}
