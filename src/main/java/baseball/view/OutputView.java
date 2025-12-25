package baseball.view;

import baseball.model.Result;

public class OutputView {

    public void printGameStartMessage() {
        System.out.println(CommonMessages.GAME_START_MESSAGE.getMessage());
    }

    public void printGuessResult(Result result) {
        System.out.println(result.toMessage());
    }

    public void printWinningMessage() {
        System.out.println(CommonMessages.WINNING_MESSAGE.getMessage());
    }
}
