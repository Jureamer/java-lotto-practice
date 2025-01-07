package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static List<Integer> LOTTO_ARRAYS = new ArrayList<>();

    static {
        for (int i = 1; i <= 45; i++) {
            LOTTO_ARRAYS.add(i);
        }
    }

    public static LottoBalls generate() {
        Collections.shuffle(LOTTO_ARRAYS);
        List<Integer> selectedNumbers = LOTTO_ARRAYS.subList(0, 6);
        Collections.sort(selectedNumbers);
        return new LottoBalls(selectedNumbers);
    }

}
