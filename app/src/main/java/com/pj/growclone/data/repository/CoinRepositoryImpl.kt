package com.pj.growclone.data.repository

import com.pj.growclone.data.remote.CoinPaprikaApi
import com.pj.growclone.data.remote.dto.CoinDetailDto
import com.pj.growclone.data.remote.dto.CoinDto
import com.pj.growclone.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl@Inject constructor(private val coinApi: CoinPaprikaApi) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return coinApi.getCoins()
    }

    override suspend fun getCoinDetails(coinId: String): CoinDetailDto {
        return coinApi.getCoinDetails(coinId)
    }
}