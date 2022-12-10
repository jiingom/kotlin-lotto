package lotto.view

import lotto.domain.Lotto

class OutputView {
    fun printLottos(lottos: List<Lotto>) {
        println(TOTAL_ISSUED_LOTTO_NUMBER_MESSAGE.format(lottos.size))
        for (lotto in lottos) {
            println(lotto.get())
        }
    }

    companion object {
        const val TOTAL_ISSUED_LOTTO_NUMBER_MESSAGE = "\n%d개를 구매했습니다."
    }
}