package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class LottoMain {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        PurchasingAmount purchasingAmount = inputView.getPurchasingAmount();
        List<Lotto> manualLottos = inputView.getManualLottos(purchasingAmount);
        Lottos lottos = new Lottos(purchasingAmount, manualLottos, new LottoGenerator());
        resultView.printLottos(lottos);
        WinningLotto winningLotto = inputView.getWinningLotto();
        resultView.printResult(lottos, winningLotto, purchasingAmount);
    }
}
