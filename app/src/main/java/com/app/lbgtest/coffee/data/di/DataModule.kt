package com.app.lbgtest.coffee.data.di

import com.app.lbgtest.coffee.data.api.CoffeeApiService
import com.app.lbgtest.coffee.data.source.CoffeeDataSource
import com.app.lbgtest.coffee.data.source.CoffeeDataSourceImpl
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DataModule {
    fun provideCoffeeDataSource(coffeeApiService: CoffeeApiService): CoffeeDataSource =
        CoffeeDataSourceImpl(coffeeApiService)
}