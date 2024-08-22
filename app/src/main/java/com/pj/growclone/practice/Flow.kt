package com.pj.growclone.practice

import androidx.lifecycle.asLiveData
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
fun main() {

    GlobalScope.launch {
        fetchNumbers().asLiveData()
    }

}

fun fetchNumbers(): Flow<Int> = flow {
    for (i in 1..5) {
        delay(1000) // simulate some work
        emit(i)     // emit the next value
    }
}

// Collecting the flow
