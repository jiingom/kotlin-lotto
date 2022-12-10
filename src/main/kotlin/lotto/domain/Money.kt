package lotto.domain

import lotto.utils.Constants

class Money(private val money: Int) {
    fun lottoAmount(): Int {
        return money / Constants.LOTTO_MONEY
    }

    fun get(): Int {
        return money
    }
}