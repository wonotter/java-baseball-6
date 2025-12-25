package baseball;

import baseball.controller.BaseballGameController;
import baseball.model.BaseballNumberGenerator;
import baseball.model.DefaultNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BaseballNumberGenerator generator = new DefaultNumberGenerator();

        BaseballGameController gameController = new BaseballGameController(inputView, outputView, generator);
        gameController.run();
    }
}
