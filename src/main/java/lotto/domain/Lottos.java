package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto> {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(PurchasingAmount purchasingAmount, LottoGenerator lottoGenerator) {
        int count = purchasingAmount.getAmount() / PurchasingAmount.MIN_AMOUNT;

        for (int i = 0; i < count; i++) {
            lottos.add(lottoGenerator.generate());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getCount() {
        return lottos.size();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }
}
