package baseball.view;

import baseball.model.Result;

public class OutputView {

    public void printGameStartMessage() {
        System.out.println(CommonMessages.GAME_START_MESSAGE.getMessage());
    }

    public void printGuessResult(Result result) {
        if (result.getBalls() == 0) {
            if (result.getStrikes() == 0) {
                System.out.println(CommonMessages.NOTHING.getMessage());
            } else {
                System.out.println(result.getStrikes() + CommonMessages.STRIKES.getMessage());
            }
        } else if (result.getStrikes() == 0) {
            System.out.println(result.getBalls() + CommonMessages.BALLS.getMessage());
        } else {
            System.out.println(
                    result.getBalls() + CommonMessages.BALLS.getMessage() +
                            " " + result.getStrikes() + CommonMessages.STRIKES.getMessage()
            );
        }
    }

    public void printWinningMessage() {
        System.out.println(CommonMessages.WINNING_MESSAGE.getMessage());
    }
}
