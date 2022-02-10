package com.dm_blinov.udemynumbercomposition.domain.repository

import com.dm_blinov.udemynumbercomposition.domain.entity.GameSettings
import com.dm_blinov.udemynumbercomposition.domain.entity.Level
import com.dm_blinov.udemynumbercomposition.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int
        , countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}