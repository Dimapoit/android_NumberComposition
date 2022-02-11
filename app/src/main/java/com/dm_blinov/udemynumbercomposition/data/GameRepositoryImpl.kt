package com.dm_blinov.udemynumbercomposition.data

import com.dm_blinov.udemynumbercomposition.domain.entity.GameSettings
import com.dm_blinov.udemynumbercomposition.domain.entity.Level
import com.dm_blinov.udemynumbercomposition.domain.entity.Question
import com.dm_blinov.udemynumbercomposition.domain.repository.GameRepository
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

object GameRepositoryImpl: GameRepository {

    private const val MIN_SUM_VALUE = 2
    private const val MIN_VISIBLE_VALUE = 1

    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue + 1)
        val visibleNumber = Random.nextInt(MIN_VISIBLE_VALUE, sum)
        val options = HashSet<Int>()
        val rightAnswer = sum - visibleNumber
        val from = max(rightAnswer - countOfOptions, MIN_VISIBLE_VALUE)
        val to =  min(maxSumValue, rightAnswer + countOfOptions)
        while (options.size < countOfOptions){
            options.add(Random.nextInt(from, to))
        }
        val question = Question(sum, visibleNumber, options.toList())
        return question
    }

    override fun getGameSettings(level: Level): GameSettings {
        return when (level) {
            Level.TEST -> {
                GameSettings(10,
                    3,
                    50,
                    8)
            }
            Level.EASY -> {
                GameSettings(10,
                    10,
                    70,
                    60)
            }
            Level.NORMAL -> {
                GameSettings(20,
                    20,
                    80,
                    40)
            }
            Level.HARD -> {
                GameSettings(30,
                    30,
                    90,
                    40)
            }
        }
    }
}