package com.pj.growclone.di

import com.pj.growclone.common.Constant
import com.pj.growclone.data.remote.CoinPaprikaApi
import com.pj.growclone.data.repository.CoinRepositoryImpl
import com.pj.growclone.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun providesCoinRepository(coinPaprikaApi: CoinPaprikaApi): CoinRepository =
        CoinRepositoryImpl(coinPaprikaApi)

}