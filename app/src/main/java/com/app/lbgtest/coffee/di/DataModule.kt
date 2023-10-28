package com.app.lbgtest.coffee.di

import com.app.lbgtest.coffeedomain.repository.CoffeeRepository
import com.app.lbgtest.data.coffee.repository.CoffeeRepositoryImpl
import com.app.lbgtest.data.coffee.source.CoffeeDataSource
import com.app.lbgtest.data.coffee.source.CoffeeDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindCoffeeRepository(coinRepositoryImpl: CoffeeRepositoryImpl): CoffeeRepository

    @Binds
    abstract fun bindCoffeeDataSourceRepository(coinRepositoryImpl: CoffeeDataSourceImpl): CoffeeDataSource

}