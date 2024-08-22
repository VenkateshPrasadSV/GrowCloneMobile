package com.pj.growclone.presentation

sealed class ScreenTwo(val route: String) {
    object CoinListScreen: ScreenTwo("coin_list_screen")
    object CoinDetailScreen: ScreenTwo("coin_detail_screen")
}