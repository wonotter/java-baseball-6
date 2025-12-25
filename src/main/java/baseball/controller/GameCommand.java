package baseball.controller;

import baseball.exception.ErrorMessage;
import java.util.Arrays;

public enum GameCommand {

    RESTART(1),
    QUIT(2);

    private final int value;

    GameCommand(int value) {
        this.value = value;
    }

    public static GameCommand from(String input) {
        int number = parseInput(input);

        return Arrays.stream(values())
                .filter(command -> command.value == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        ErrorMessage.GAME_CONTINUE_FAIL.getMessage()));
    }

    private static int parseInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.GAME_CONTINUE_FAIL.getMessage());
        }
    }

    public boolean isQuit() {
        return this == QUIT;
    }
}
