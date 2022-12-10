package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        isLottoNumberDuplicated(numbers)
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    fun match(lotto: Lotto): Int {
        var count = 0
        for (number in numbers) {
            if (lotto.contains(number)) {
                count += 1
            }
        }
        return count
    }

    fun hasDuplicatedBonusNumber(bonus: Int): Boolean {
        return numbers.contains(bonus)
    }

    fun get(): List<Int> {
        return numbers
    }

    private fun isLottoNumberDuplicated(numbers: List<Int>) {
        if (numbers.distinct().size != 6) {
            throw IllegalArgumentException(DUPLICATE_ERROR_MESSAGE)
        }
    }

    companion object {
        const val DUPLICATE_ERROR_MESSAGE = "[ERROR]: 로또는 중복되지 않는 6개의 숫자를 가져야 한다."
    }
}
