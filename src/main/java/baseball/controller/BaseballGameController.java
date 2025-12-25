package baseball.controller;

import baseball.model.BaseballNumberGenerator;
import baseball.model.Number;
import baseball.model.Numbers;
import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BaseballGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballNumberGenerator generator;

    public BaseballGameController(InputView inputView, OutputView outputView, BaseballNumberGenerator generator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.generator = generator;
    }

    public void run() {
        outputView.printGameStartMessage();

        while (true) {
            // 무작위 번호 3개 생성
            Numbers answerNumbers = new Numbers(generator.generate());

            playGame(answerNumbers);

            GameCommand command = GameCommand.from(inputView.askRetry());

            if (command.isQuit()) {
                break;
            }
        }
    }

    private void playGame(Numbers answerNumbers) {
        while (true) {
            // 사용자에게 번호 입력받기
            Numbers userNumbers = readNumbers();

            Result result = answerNumbers.compare(userNumbers);
            outputView.printGuessResult(result);

            // 스트라이크가 3개인 경우
            if (result.isGameOver()) {
                outputView.printWinningMessage();
                break;
            }
        }
    }

    private Numbers readNumbers() {
        List<Number> numbers = new ArrayList<>();

        String input = inputView.readNumber();

        for (String inputNumber : input.split("")) {
            Number number = Number.from(inputNumber);
            numbers.add(number);
        }

        return new Numbers(numbers);
    }
}
