package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final int LOTTO_COUNT = 6;
    LinkedHashSet<LottoBall> lottoBalls = new LinkedHashSet<>();

    public Lotto(List<Integer> values) {
        validate(values);
        for (int value : values) {
            lottoBalls.add(new LottoBall(value));
        }
    }

    public Lotto(String s) {
        this(Arrays.stream(s.split(",")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList()));
    }

    private void validate(List<Integer> values) {
        if (values.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_COUNT + "개여야 합니다.");
        }

        if (new HashSet<>(values).size() != values.size()) {
            throw new IllegalArgumentException("로또 번호에 중복이 있습니다.");
        }
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
