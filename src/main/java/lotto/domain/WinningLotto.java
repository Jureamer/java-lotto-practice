package lotto.domain;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class WinningLotto extends Lotto {
    public WinningLotto(String s) {
        super(s);
    }

    public int match(Lotto lotto) {
        return (int) lotto.getValues().stream()
                .filter(getValues()::contains)
                .count();
    }
}
