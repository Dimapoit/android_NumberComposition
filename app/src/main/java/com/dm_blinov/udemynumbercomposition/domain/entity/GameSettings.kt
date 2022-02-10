package com.dm_blinov.udemynumbercomposition.domain.entity

data class GameSettings(
    val maxSumValue: Int,
    val minCountOfRightAnswers: Int,
    val munPercentOfRightAnswers: Int,
    val gameTimeInSeconds: Int
)