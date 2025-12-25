package baseball.model;

import baseball.exception.ErrorMessage;
import java.util.Objects;

public class Number {

    private final int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number from(String input) {
        int number = validateNumber(input);
        int validNumber = validateRange(number);

        return new Number(validNumber);
    }

    private static int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_NOT_SUPPORTED.getMessage());
        }
    }

    private static int validateRange(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.getMessage());
        }

        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Number that = (Number) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
