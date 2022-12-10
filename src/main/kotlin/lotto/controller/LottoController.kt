package lotto.controller

import lotto.view.InputView

class LottoController {
    fun run() {
        val money = InputView().readAmount()
    }
}