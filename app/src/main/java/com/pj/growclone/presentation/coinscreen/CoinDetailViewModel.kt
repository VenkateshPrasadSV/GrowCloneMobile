package com.pj.growclone.presentation.coinscreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pj.growclone.common.Resource
import com.pj.growclone.domain.usecase.getcoin.GetCoinDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val mCoinDetailsUseCase: GetCoinDetailsUseCase,
    private val mSavedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    private fun getCoins(coinId: String) {
        mCoinDetailsUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinDetailState(coins = result.data)
                }

                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value = CoinDetailState(error = "API error")
                }
            }
        }.launchIn(viewModelScope)
    }
}
