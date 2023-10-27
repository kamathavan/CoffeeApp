package com.app.lbgtest.data.coffee.di

import com.app.lbgtest.data.coffee.api.CoffeeApiServices
import com.app.lbgtest.data.coffee.repository.CoffeeRepository
import com.app.lbgtest.data.coffee.repository.CoffeeRepositoryImpl
import com.app.lbgtest.data.coffee.source.CoffeeDataSource
import com.app.lbgtest.data.coffee.source.CoffeeDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DataModule {

    @Provides
    fun providesDataSource(coffeeApiServices: CoffeeApiServices): CoffeeDataSource =
        CoffeeDataSourceImpl(coffeeApiService = coffeeApiServices)

    @Provides
    fun provideCoffeeRepository(coffeeDataSource: CoffeeDataSource): CoffeeRepository =
        CoffeeRepositoryImpl(coffeeDataSource = coffeeDataSource)
}