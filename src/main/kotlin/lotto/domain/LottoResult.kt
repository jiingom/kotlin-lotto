package lotto.domain

import kotlin.math.round

class LottoResult(private val result: Map<Rank, Int>) {
    fun calculateProfitRate(inputMoney: Int): Double {
        val totalAmount = calculateTotalPrize()
        val profitRate = (totalAmount / inputMoney.toDouble()) * PROFIT_RATE_PERCENTAGE
        return round(profitRate * 10) / 10
    }

    private fun calculateTotalPrize(): Int {
        var prize = 0
        for (index in result) {
            if (index.value > 0) {
                prize += index.key.money() * index.value
            }
        }
        return prize
    }

    fun getResult(): Map<Rank, Int> {
        return result
    }

    companion object {
        const val PROFIT_RATE_PERCENTAGE = 100
    }
}