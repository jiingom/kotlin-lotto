package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.Lotto
import lotto.domain.Money
import lotto.utils.InputValidator

class InputView {
    fun readAmount(): Money {
        println(READ_AMOUNT_MESSAGE)
        return InputValidator().getAmount(Console.readLine())
    }

    fun readWinningLotto(): Lotto {
        println(READ_WINNING_LOTTO_MESSAGE)
        return InputValidator().getWinningLotto(Console.readLine())
    }

    fun readBonusNumber(): Int {
        println(READ_BONUS_NUMBER_MESSAGE)
        return InputValidator().getBonusNumber(Console.readLine())
    }

    companion object {
        const val READ_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
        const val READ_WINNING_LOTTO_MESSAGE = "\n당첨 번호를 입력해 주세요."
        const val READ_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요."
    }
}