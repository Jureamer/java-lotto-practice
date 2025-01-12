package lotto.view;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public final Scanner scanner = new Scanner(System.in);

    public PurchasingAmount getPurchasingAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        while (true) {
            try {
                return new PurchasingAmount(Integer.parseInt(scanner.nextLine()));
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력 가능합니다.");
            }
        }
    }

    public WinningLotto getWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningLotto = scanner.nextLine();
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusNumber = scanner.nextLine();
        return new WinningLotto(winningLotto, bonusNumber);
    }

    public List<Lotto> getManualLottos(PurchasingAmount purchasingAmount) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCount = Integer.parseInt(scanner.nextLine());

        if (manualCount > purchasingAmount.getAmount() / PurchasingAmount.MIN_AMOUNT) {
            throw new IllegalArgumentException("수동으로 구매할 수 있는 로또의 개수를 초과하였습니다.");
        }
        ArrayList<Lotto> lottos = new ArrayList<>();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualCount; i++) {
            lottos.add(new Lotto(scanner.nextLine()));
        }
        return lottos;
    }
}
