package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class DefaultNumberGenerator implements BaseballNumberGenerator {

    @Override
    public List<Number> generate() {
        List<Number> computer = new ArrayList<>();

        while (computer.size() < 3) {
            Number randomNumber = new Number(Randoms.pickNumberInRange(1, 9));

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}
