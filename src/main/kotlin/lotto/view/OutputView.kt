package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoResult
import lotto.domain.Money
import lotto.domain.Rank
import java.text.DecimalFormat

class OutputView {
    fun printLottos(lottos: List<Lotto>) {
        println(TOTAL_ISSUED_LOTTO_NUMBER_MESSAGE.format(lottos.size))
        for (lotto in lottos) {
            println(lotto.get())
        }
    }

    fun printResult(money: Money, lottoResult: LottoResult) {
        println(WINNING_STATISTICS)
        val result = lottoResult.getResult()
        printReward(result)
        printProfitRate(lottoResult.calculateProfitRate(money.get()))
    }

    private fun printReward(result: Map<Rank, Int>) {
        println(FIFTH_MESSAGE.format(result[Rank.FIFTH]))
        println(FOURTH_MESSAGE.format(result[Rank.FOURTH]))
        println(THIRD_MESSAGE.format(result[Rank.THIRD]))
        println(SECOND_MESSAGE.format(result[Rank.SECOND]))
        println(FIRST_MESSAGE.format(result[Rank.FIRST]))
    }

    private fun printProfitRate(profit: Double) {
        println(TOTAL_YIELD_MESSAGE.format(profit))
    }

    companion object {
        const val WINNING_STATISTICS = "\n당첨 통계\n" + "---"
        const val TOTAL_ISSUED_LOTTO_NUMBER_MESSAGE = "\n%d개를 구매했습니다."
        const val TOTAL_YIELD_MESSAGE = "총 수익률은 %s%%입니다."
        const val FIRST_MESSAGE = "6개 일치 (2,000,000,000원) - %d개"
        const val THIRD_MESSAGE = "5개 일치 (1,500,000원) - %d개"
        const val SECOND_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"
        const val FOURTH_MESSAGE = "4개 일치 (50,000원) - %d개"
        const val FIFTH_MESSAGE = "3개 일치 (5,000원) - %d개"
    }
}