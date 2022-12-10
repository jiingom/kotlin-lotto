package lotto.utils

import lotto.domain.Lotto
import lotto.domain.Money
import lotto.utils.Constants.LOTTO_NUMBER
import lotto.utils.Constants.MAXIMUM_LOTTO_NUMBER
import lotto.utils.Constants.MINIMUM_LOTTO_NUMBER

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

    fun getWinningLotto(numbers: String): Lotto {
        validateWinningLotto(numbers)
        return Lotto(numbers.split(",").map { it.toInt() })
    }

    private fun validateWinningLotto(winNumbers: String) {
        val numbers = winNumbers.split(",")
        require(numbers.all { it.toInt() in MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER } &&
                numbers.size == LOTTO_NUMBER)
        {
            INPUT_WINNING_LOTTO_ERROR_MESSAGE
        }
    }

    fun getBonusNumber(bonusNumber: String): Int {
        validateBonusNumber(bonusNumber)
        return bonusNumber.toInt()
    }

    private fun validateBonusNumber(number: String) {
        require(number.toInt() in MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER) {
            INPUT_BONUS_NUMBER_ERROR_MESSAGE
        }
    }

    companion object {
        const val INPUT_AMOUNT_ERROR_MESSAGE = "[ERROR] 입력 단위는 1,000원 이어야 합니다."
        const val INPUT_WINNING_LOTTO_ERROR_MESSAGE = "[ERROR] 서로 다른 1~45 사이의 숫자 6개를 ,로 구분해 입력해야 합니다."
        const val INPUT_BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다."
    }
}