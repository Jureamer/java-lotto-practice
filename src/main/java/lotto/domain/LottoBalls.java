package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBalls {
    List<LottoBall> lottoBalls = new ArrayList<>();

    public LottoBalls(List<Integer> values) {
        for (int value : values) {
            lottoBalls.add(new LottoBall(value));
        }
    }

    public LottoBalls(int value1, int value2, int value3, int value4, int value5, int value6) {
        lottoBalls.add(new LottoBall(value1));
        lottoBalls.add(new LottoBall(value2));
        lottoBalls.add(new LottoBall(value3));
        lottoBalls.add(new LottoBall(value4));
        lottoBalls.add(new LottoBall(value5));
        lottoBalls.add(new LottoBall(value6));
    }

    public LottoBalls(LottoBall lottoBall1, LottoBall lottoBall2, LottoBall lottoBall3, LottoBall lottoBall4, LottoBall lottoBall5, LottoBall lottoBall6) {
        this.lottoBalls.add(lottoBall1);
        this.lottoBalls.add(lottoBall2);
        this.lottoBalls.add(lottoBall3);
        this.lottoBalls.add(lottoBall4);
        this.lottoBalls.add(lottoBall5);
        this.lottoBalls.add(lottoBall6);
    }

    public List<LottoBall> getBalls() {
        return lottoBalls;
    }

    public List<Integer> getValues() {
        List<Integer> values = new ArrayList<>();
        for (LottoBall lottoBall : lottoBalls) {
            values.add(lottoBall.getNumber());
        }
        return values;
    }

    @Override
    public String toString() {
        return lottoBalls.stream().map(LottoBall::getNumber).map(String::valueOf).reduce((a, b) -> a + ", " + b).get();
    }
}
