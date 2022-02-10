package com.dm_blinov.udemynumbercomposition.domain.usecases

import com.dm_blinov.udemynumbercomposition.domain.entity.GameSettings
import com.dm_blinov.udemynumbercomposition.domain.entity.Question
import com.dm_blinov.udemynumbercomposition.domain.repository.GameRepository

class GenerateQuestionUseCase(
    private val repository: GameRepository
) {
//    fun generateQuestion(mamSum: Int) : Question() {
//        return repository.generateQuestion(mamSum, COUNT_OF_OPTIONS)
//    }
    operator fun invoke(mamSum: Int): Question {
        return repository.generateQuestion(mamSum, COUNT_OF_OPTIONS)
    }
    private companion object {
        private  const val COUNT_OF_OPTIONS = 6
    }
}