package lotto.domain

class WinningLotto(
    private val winLotto: Lotto,
    private val bonusNumber: Int
) {
    init {
        validateLotto()
    }

    fun matchResult(lottos: List<Lotto>): Map<Rank, Int> {
        val result = initResult()
        for (lotto in lottos) {
            val countOfMatch = lotto.match(winLotto)
            val hasBonusNumber = lotto.contains(bonusNumber)
            val rank = checkLotto(countOfMatch, hasBonusNumber)
            result[rank] = result[rank]!! + 1
        }
        return result
    }

    private fun initResult(): MutableMap<Rank, Int> {
        val result = mutableMapOf<Rank, Int>()
        for (rank in Rank.values()) {
            result[rank] = 0
        }
        return result
    }

    private fun checkLotto(matchedNum: Int, hasBonusNumber: Boolean): Rank {
        return when (matchedNum) {
            Rank.FIRST.rank() -> Rank.FIRST
            Rank.SECOND.rank() -> {
                if (hasBonusNumber) Rank.SECOND else Rank.THIRD
            }
            Rank.FOURTH.rank() -> Rank.FOURTH
            Rank.FIFTH.rank() -> Rank.FIFTH
            else -> Rank.MISS
        }
    }

    private fun validateLotto() {
        if (winLotto.hasDuplicatedBonusNumber(bonusNumber)) {
            throw IllegalArgumentException(WINNING_LOTTO_ERROR_MESSAGE)
        }
    }

    companion object {
        const val WINNING_LOTTO_ERROR_MESSAGE = "[ERROR]: 당첨 번호와 보너스 번호는 중복되지 않아야 합니다."
    }
}