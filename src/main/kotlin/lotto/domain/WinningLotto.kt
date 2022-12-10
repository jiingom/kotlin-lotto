package lotto.domain

class WinningLotto(
    private val winLotto: Lotto,
    private val bonusNumber: Int
) {
    init {
        validateLotto()
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