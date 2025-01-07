package lotto.view;

import lotto.domain.PurchasingAmount;

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
}
