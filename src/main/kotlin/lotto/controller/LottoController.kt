package lotto.controller

import lotto.domain.LottoResult
import lotto.domain.LottoVendingMachine
import lotto.domain.WinningLotto
import lotto.utils.InputValidator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun run() {
        val money = InputView().readAmount()
        val winningLotto = getWinningLotto()
        val lottos = LottoVendingMachine().issueLottos(money.lottoAmount())
        OutputView().printLottos(lottos)
        val result = LottoResult(winningLotto.matchResult(lottos))
        OutputView().printResult(money, result)
    }

    private fun getWinningLotto(): WinningLotto {
        val numbers = InputView().readWinningLotto()
        val bonusNumber = InputView().readBonusNumber()
        return WinningLotto(numbers, bonusNumber)
    }
}