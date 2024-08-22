package com.pj.growclone.presentation.coinslist.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pj.growclone.presentation.coinslist.CoinsListViewModel


@Composable
fun CoinListScreen(
    modifier: Modifier = Modifier,
    viewModel: CoinsListViewModel = hiltViewModel()
) {

    Box(modifier = modifier.fillMaxSize()) {
        val state = remember { viewModel.state}
        LazyColumn(modifier = Modifier) {
            items(state.value.coins) {
                CoinListItem(
                    coin = it,
                    onItemClicked = { }
                )
            }
        }

        if (state.value.error.isNotBlank()) {
            Text(
                text = state.value.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

//        if(state.value.isLoading) {
//            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
//        }
    }
}