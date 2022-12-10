package lotto

import lotto.controller.LottoController

fun main() {
    val game = LottoController()
    try {
        game.run()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
