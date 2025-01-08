package lotto.view;

import lotto.domain.LottoBall;
import lotto.domain.PurchasingAmount;
import lotto.domain.WinningLotto;

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
        return new WinningLotto(winningLotto);
    }
}
