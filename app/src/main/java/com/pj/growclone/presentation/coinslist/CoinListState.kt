package com.pj.growclone.presentation.coinslist

import com.pj.growclone.domain.model.Coin

data class CoinListState(
    val coins: List<Coin> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)