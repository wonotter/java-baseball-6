package baseball.model;

import baseball.exception.ErrorMessage;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Numbers {

    private static final int NUMBER_RANGE = 3;

    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Number> numbers) {
        validateCount(numbers);
        validateDuplicate(numbers);
    }

    private void validateCount(List<Number> numbers) {
        if (numbers.size() != NUMBER_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_SIZE_NOT_MATCH.getMessage());
        }
    }

    private void validateDuplicate(List<Number> numbers) {
        Set<Number> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATED.getMessage());
        }
    }

    public Result compare(Numbers otherNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).equals(otherNumbers.numbers.get(i))) {
                strikes++;
            }
        }

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                if (i != j && numbers.get(i).equals(otherNumbers.numbers.get(j))) {
                    balls++;
                }
            }
        }

        return new Result(strikes, balls);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(n -> n.toString())
                .collect(Collectors.joining());
    }
}
