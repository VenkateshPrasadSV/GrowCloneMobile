package com.pj.growclone.domain.usecase.getcoin

import com.pj.growclone.common.Resource
import com.pj.growclone.data.remote.dto.toCoinDetail
import com.pj.growclone.domain.model.CoinDetail
import com.pj.growclone.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinDetailsUseCase @Inject constructor(private val mCoinRepository: CoinRepository) {

    operator fun invoke(coinId : String) : Flow<Resource<CoinDetail>> = flow {
        runCatching {
            emit(Resource.Loading())
            val coinDetail = mCoinRepository.getCoinDetails(coinId).toCoinDetail()
            emit(Resource.Success(coinDetail))
        }.onFailure {
            emit(Resource.Error(it.localizedMessage ?: "Unknown Error"))
        }
    }
}