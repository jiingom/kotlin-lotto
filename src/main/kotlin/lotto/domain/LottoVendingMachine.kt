package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.Constants.LOTTO_NUMBER
import lotto.utils.Constants.MAXIMUM_LOTTO_NUMBER
import lotto.utils.Constants.MINIMUM_LOTTO_NUMBER

class LottoVendingMachine {
    fun issueLottos(lottoAmount: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        repeat(lottoAmount) { lottos.add(issueLotto()) }
        return lottos
    }

    private fun issueLotto(): Lotto {
        return Lotto(
            Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_NUMBER).sorted()
        )
    }
}