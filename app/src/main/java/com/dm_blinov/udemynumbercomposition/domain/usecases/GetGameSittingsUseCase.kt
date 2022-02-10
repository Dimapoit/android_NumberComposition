package com.dm_blinov.udemynumbercomposition.domain.usecases

import com.dm_blinov.udemynumbercomposition.domain.entity.GameSettings
import com.dm_blinov.udemynumbercomposition.domain.entity.Level
import com.dm_blinov.udemynumbercomposition.domain.repository.GameRepository

class GetGameSittingsUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(level:Level): GameSettings {

        return repository.getGameSettings(level)
    }
}