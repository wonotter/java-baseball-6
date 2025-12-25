package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readNumber() {
        System.out.print(CommonMessages.INPUT_MESSAGE.getMessage());

        return Console.readLine();
    }

    public String askRetry() {
        System.out.println(CommonMessages.GAME_RETRY_MESSAGE.getMessage());

        return Console.readLine();
    }
}
