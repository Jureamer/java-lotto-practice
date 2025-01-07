package lotto;

import lotto.domain.LottoBalls;
import lotto.domain.LottoGenerator;
import lotto.domain.PurchasingAmount;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        PurchasingAmount purchasingAmount = inputView.getPurchasingAmount();
        Lottos lottos = new Lottos(purchasingAmount, new LottoGenerator());
        resultView.printLottos(lottos);
    }
}
