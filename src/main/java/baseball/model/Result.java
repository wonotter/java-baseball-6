package baseball.model;

public class Result {

    private static final String NOTHING = "낫싱";
    private static final String STRIKES = "스트라이크";
    private static final String BALLS = "볼";

    private final int strikes;
    private final int balls;

    public Result(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean isGameOver() {
        return strikes == 3;
    }

    private boolean isNothing() {
        return strikes == 0 && balls == 0;
    }

    public String toMessage() {
        if (isNothing()) {
            return NOTHING;
        }

        StringBuilder sb = new StringBuilder();

        if (balls > 0) {
            sb.append(balls).append(BALLS);
        }

        if (strikes > 0) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(strikes).append(STRIKES);
        }

        return sb.toString();
    }
}
