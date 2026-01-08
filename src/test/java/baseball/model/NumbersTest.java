package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumbersTest {

    @Nested
    @DisplayName("생성 테스트")
    class 생성_테스트 {

        @Test
        @DisplayName("숫자 야구를 위해 번호 3개를 정상적으로 생성할 수 있다.")
        void 정상_생성() {
            // given
            List<Number> baseballs = List.of(
                    Number.from("1"),
                    Number.from("2"),
                    Number.from("3")
            );

            // when
            Numbers numbers = new Numbers(baseballs);

            // then
            assertThat(numbers).isNotNull();
        }
    }

    @Nested
    @DisplayName("예외 발생 테스트")
    class 예외_발생 {

        @ParameterizedTest
        @ValueSource(strings = {"1234", "12", "1", "1234567"})
        @DisplayName("입력한 숫자의 개수가 정확히 3개가 아닌 경우 예외가 발생한다.")
        void 숫자_개수_테스트(String input) {
            // given
            List<Number> baseballs = new ArrayList<>();

            for (String inputNumber : input.split("")) {
                baseballs.add(Number.from(inputNumber));
            }

            // when & then
            assertThatThrownBy(() -> new Numbers(baseballs))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자 3개를 입력해 주세요.");


        }
    }
}