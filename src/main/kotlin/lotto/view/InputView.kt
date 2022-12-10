package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.Money
import lotto.utils.InputValidator

class InputView {
    fun readAmount(): Money {
        println(READ_AMOUNT_MESSAGE)
        return InputValidator().getAmount(Console.readLine())
    }

    companion object {
        const val READ_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
    }
}