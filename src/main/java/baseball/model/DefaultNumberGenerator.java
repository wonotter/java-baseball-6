package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class DefaultNumberGenerator implements BaseballNumberGenerator {

    @Override
    public List<Number> generate() {
        List<Number> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int pickedNumber = Randoms.pickNumberInRange(1, 9);
            Number randomNumber = Number.from(Integer.toString(pickedNumber));

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}
