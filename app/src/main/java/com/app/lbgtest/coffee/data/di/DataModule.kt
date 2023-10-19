package com.app.lbgtest.coffee.data.di

import com.app.lbgtest.coffee.data.api.CoffeeApiService
import com.app.lbgtest.coffee.data.source.CoffeeDataSource
import com.app.lbgtest.coffee.data.source.CoffeeDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DataModule {

    @Provides
    fun provideCoffeeDataSource(coffeeApiService: CoffeeApiService): CoffeeDataSource =
        CoffeeDataSourceImpl(coffeeApiService)
}