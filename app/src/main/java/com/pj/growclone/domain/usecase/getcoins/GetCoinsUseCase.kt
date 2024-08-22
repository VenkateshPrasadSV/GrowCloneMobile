package com.pj.growclone.domain.usecase.getcoins

import com.pj.growclone.common.Resource
import com.pj.growclone.data.remote.dto.toCoin
import com.pj.growclone.domain.model.Coin
import com.pj.growclone.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val mCoinsRepository: CoinRepository) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        runCatching {
            emit(Resource.Loading())
            val coins = mCoinsRepository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        }.onFailure {
            emit(Resource.Error(data = null, message = it.message.toString()))
        }
    }
}