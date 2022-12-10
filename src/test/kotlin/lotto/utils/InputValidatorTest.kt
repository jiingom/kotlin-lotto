package lotto.utils

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.junit.jupiter.api.assertThrows

internal class InputValidatorTest {
    @ValueSource(strings = ["999", "0", "-123"])
    @ParameterizedTest
    fun `천원 미만의 금액에 대한 예외 처리`(input: String) {
        assertThrows<IllegalArgumentException> {
            InputValidator().getAmount(input)
        }
    }

    @ValueSource(strings = ["abc", " ", "@#"])
    @ParameterizedTest
    fun `숫자 이외의 입력에 대한 예외 처리`(input: String) {
        assertThrows<IllegalArgumentException> {
            InputValidator().getAmount(input)
        }
    }
}