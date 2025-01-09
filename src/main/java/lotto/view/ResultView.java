package lotto.view;

import lotto.domain.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
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
        printWinningResultInformString();
        Map<Rank, Long> rankCounts = lottos.getLottos().stream()
                .map(winningLotto::match)
                .map(count -> Rank.valueOf(count, false))
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));

        Optional<Long> totalWinningMoney = calculateWinningMoney(rankCounts);
        printWinningResults(rankCounts);
        printRateOfReturn(totalWinningMoney, purchasingAmount);
    }

    private void printRateOfReturn(Optional<Long> totalWinningMoney, PurchasingAmount purchasingAmount) {
        if (totalWinningMoney.isEmpty()) {
            System.out.println("총 당첨 금액이 없습니다. (수익률 계산 불가)");
            return;
        }

        long winningMoney = totalWinningMoney.get();
        double rateOfReturn = (double) winningMoney / purchasingAmount.getAmount();
        rateOfReturn = Math.round(rateOfReturn * 100) / 100.0;

        System.out.print("총 수익률은 " + rateOfReturn  + "입니다.");
        if (rateOfReturn > 1) {
            System.out.println(" (이익입니다.)");
        } else {
            System.out.println(" (손해입니다.)");
        }
    }

    private void printWinningResults(Map<Rank, Long> rankCounts) {
        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) {
                continue;
            }
            printRankResult(rank, rankCounts.getOrDefault(rank, 0L));
        }
    }

    private void printRankResult(Rank rank, long count) {
        System.out.print(rank.getCountOfMatch() + "개 일치");
        if (rank == Rank.SECOND) {
            System.out.print(", 보너스 볼 일치");
        }
        System.out.println("(" + rank.getWinningMoney() + "원)- " + count + "개");
    }

    private void printWinningResultInformString() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private Optional<Long> calculateWinningMoney(Map<Rank, Long> rankCounts) {
        return Arrays.stream(Rank.values()).map(rank -> rank.getWinningMoney() * rankCounts.getOrDefault(rank, 0L)).reduce(Long::sum);
    }
}
