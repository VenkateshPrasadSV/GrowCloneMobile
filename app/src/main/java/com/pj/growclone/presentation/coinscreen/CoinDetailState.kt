package com.pj.growclone.presentation.coinscreen

import com.pj.growclone.domain.model.CoinDetail

data class CoinDetailState(
    val coins: CoinDetail? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)