package baseball.exception;

public enum ErrorMessage {

    NUMBER_NOT_SUPPORTED("1~9 사이 정수만 입력 가능합니다."),
    NUMBER_OUT_OF_RANGE("유효한 숫자 범위를 벗어났습니다."),
    NUMBER_SIZE_NOT_MATCH("숫자 3개를 입력해 주세요."),
    NUMBER_DUPLICATED("중복된 숫자는 입력할 수 없습니다."),
    GAME_CONTINUE_FAIL("게임을 새로 시작하려면 1, 종료하려면 2를 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
