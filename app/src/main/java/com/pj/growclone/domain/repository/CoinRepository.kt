package com.pj.growclone.domain.repository

import com.pj.growclone.data.remote.dto.CoinDetailDto
import com.pj.growclone.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinDetails(coinId: String) : CoinDetailDto
}