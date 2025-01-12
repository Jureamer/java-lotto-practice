package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto> {
    private List<Lotto> lottos = new ArrayList<>();
    private int manualCount = 0;

    public Lottos(PurchasingAmount purchasingAmount, LottoGenerator lottoGenerator) {
        int count = purchasingAmount.getAmount() / PurchasingAmount.MIN_AMOUNT;

        for (int i = 0; i < count; i++) {
            lottos.add(lottoGenerator.generate());
        }
    }

    public Lottos(PurchasingAmount purchasingAmount, List<Lotto> manualLottos, LottoGenerator lottoGenerator) {
        lottos.addAll(manualLottos);
        manualCount = manualLottos.size();
        int count = (purchasingAmount.getAmount() / PurchasingAmount.MIN_AMOUNT) - manualLottos.size();

        for (int i = 0; i < count; i++) {
            lottos.add(lottoGenerator.generate());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getAutoSize() {
        return lottos.size() - manualCount;
    }

    public int getManualCount() {
        return manualCount;
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }
}
