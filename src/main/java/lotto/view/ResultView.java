package lotto.view;

import lotto.Lottos;
import lotto.domain.Lotto;

public class ResultView {
    public void printLottos(Lottos lottos) {
        printPurchasingAmount(lottos.getCount());
        lottos.getLottos().stream().map(Lotto::toString).forEach(System.out::println);

    }

    private void printPurchasingAmount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }
}
