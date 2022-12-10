package lotto.utils

import lotto.domain.Lotto
import lotto.domain.Money
import lotto.utils.Constants.LOTTO_NUMBER
import lotto.utils.Constants.MAXIMUM_LOTTO_NUMBER
import lotto.utils.Constants.MINIMUM_LOTTO_NUMBER
import lotto.view.InputView

class InputValidator {
    fun getAmount(amount: String): Money {
        validateAmount(amount)
        return Money(amount.toInt())
    }

    private fun validateAmount(amount: String) {
        require(amount.all { it in '0'..'9' } &&
                amount.toInt() >= Constants.LOTTO_MONEY &&
                amount.toInt() % Constants.LOTTO_MONEY == 0)
        {
            INPUT_AMOUNT_ERROR_MESSAGE
        }
    }

    companion object {
        const val INPUT_AMOUNT_ERROR_MESSAGE = "[ERROR] 입력 단위는 1,000원 이어야 합니다."
    }
}