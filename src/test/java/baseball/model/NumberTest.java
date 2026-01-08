package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @Nested
    @DisplayName("생성 테스트")
    class 생성_테스트 {

        @DisplayName("1 ~ 9 사이 번호를 생성할 수 있다.")
        @ParameterizedTest
        @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9"})
        void 정상_생성_테스트(String input) {
            // given
            Number number = Number.from(input);

            // when & then
            assertThat(number).isEqualTo(Number.from(input));
        }
    }

    @Nested
    @DisplayName("equals와 hashCode 테스트")
    class Equals_HashCode_테스트 {

        @Test
        @DisplayName("같은 번호를 가진 Number 객체는 동등하다.")
        void 동등성_테스트() {
            // given
            Number number1 = Number.from("1");
            Number number2 = Number.from("1");

            // when & then
            assertThat(number1).isEqualTo(number2);
        }

        @Test
        @DisplayName("다른 번호를 가진 Number 객체는 동등하지 않다.")
        void 비동등성_테스트() {
            // given
            Number number1 = Number.from("1");
            Number number2 = Number.from("2");

            // when & then
            assertThat(number1).isNotEqualTo(number2);
        }

        @Test
        @DisplayName("같은 번호를 가진 Number 객체는 같은 hashCode를 가진다.")
        void hashCode_동등성_테스트() {
            // given
            Number number1 = Number.from("1");
            Number number2 = Number.from("1");

            // when & then
            assertThat(number1.hashCode()).isEqualTo(number2.hashCode());
        }
    }

    @Nested
    @DisplayName("예외 발생 테스트")
    class 예외_테스트 {

        @DisplayName("숫자가 아닌 문자를 입력하면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"abc", "blablabla", "test"})
        void 문자_입력_테스트(String input) {
            assertThatThrownBy(() -> Number.from(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("1~9 사이 정수만 입력 가능합니다.");
        }

        @DisplayName("1 ~ 9 숫자 범위를 넘어서면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"0", "10", "100", "-1", "-200"})
        void 숫자_범위_테스트(String input) {
            assertThatThrownBy(() -> Number.from(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("유효한 숫자 범위를 벗어났습니다.");
        }
    }
}