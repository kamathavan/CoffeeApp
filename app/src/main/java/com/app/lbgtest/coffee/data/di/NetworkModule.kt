package com.app.lbgtest.coffee.data.di

import com.app.lbgtest.coffee.data.api.CoffeeApiService
import com.app.lbgtest.coffee.utils.Constants.BASE_URL
import com.app.lbgtest.coffee.utils.Constants.TIME_OUT
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }



    @Singleton
    @Provides
    fun providesCoffeeApiService(retrofit: Retrofit): CoffeeApiService =
        retrofit.create(CoffeeApiService::class.java)

    @Singleton
    @Provides
    fun provideGsonFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .callTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            .connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideLoggingHttpInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
    }

}