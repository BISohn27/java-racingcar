package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	StringCalculator stringCalculator = new StringCalculator();

	@DisplayName("null과 빈 문자열은 0으로 취급한다")
	@Test
	void consider_null_and_blank_as_zero() {
		assertThat(stringCalculator.calculate(null)).isZero();
		assertThat(stringCalculator.calculate("")).isZero();
		assertThat(stringCalculator.calculate(",1")).isOne();
	}

	@DisplayName("문자열에서 숫자를 분리해 더한다")
	@Test
	void split_and_sum() {
		assertThat(stringCalculator.calculate("1,2,3")).isEqualTo(6);
	}

	@DisplayName("쉼표나 콜론을 구분자로 사용한다")
	@Test
	void comma_or_colon_is_a_separator() {
		assertThat(stringCalculator.calculate("1,2:3")).isEqualTo(6);
	}

	@DisplayName("숫자 하나는 그대로 반환한다")
	@Test
	void return_single_number_untouched() {
		assertThat(stringCalculator.calculate("33")).isEqualTo(33);
	}

	@DisplayName("커스텀 구분자를 지정할 수 있다")
	@Test
	void custom_separator_available() {
		String input = "//;\n1;2;3";

		assertThat(stringCalculator.calculate(input)).isEqualTo(6);
	}

	@DisplayName("수식에 문자가 있으면 안된다")
	@Test
	void character_should_not_be_in_expression() {
		String input = "//;\n1;2;z;3";

		assertThatThrownBy(() -> stringCalculator.calculate(input))
			.isInstanceOf(RuntimeException.class);
	}

	@DisplayName("수식에 음수가 있으면 안된다")
	@Test
	void negative_should_not_be_in_expression() {
		String input = "//;\n1;2;-1;3";

		assertThatThrownBy(() -> stringCalculator.calculate(input))
			.isInstanceOf(RuntimeException.class);
	}
}