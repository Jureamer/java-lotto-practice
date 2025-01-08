package lotto.view;

import lotto.domain.*;

import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    public void printLottos(Lottos lottos) {
        printPurchasingAmount(lottos.getCount());
        lottos.getLottos().stream().map(Lotto::toString).forEach(System.out::println);

    }

    private void printPurchasingAmount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printResult(Lottos lottos, WinningLotto winningLotto, PurchasingAmount purchasingAmount) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        Map<Rank, Long> rankCounts = lottos.getLottos().stream()
                .map(winningLotto::match)
                .map(count -> Rank.valueOf(count))
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));

        // Todo: indent 줄이기
        int totalWinningMoney = 0;
        for (Rank rank : Rank.values()) {
            long count = rankCounts.getOrDefault(rank, 0L);

            if (rank != Rank.MISS) {
                System.out.println(rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원)- " + count + "개");
                totalWinningMoney += rank.getWinningMoney() * count;
            }
        }

        // Todo: 별도 메소드로 추출
        double rateOfReturn = (double) totalWinningMoney / purchasingAmount.getAmount();
        System.out.print("총 수익률은 " + rateOfReturn  + "입니다.");

        if (rateOfReturn > 1) {
            System.out.println(" (이익입니다.)");
        } else {
            System.out.println(" (손해입니다.)");
        }
        System.out.println();
    }
}
