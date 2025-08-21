package com.ghostcorp.designpatterns

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DependencyInjectionPatternModule {

    @Singleton
    @Provides
    fun provideHamburger() :Hamburger{
        return Hamburger.Builder()
            .cheese(true)
            .lettuce(true)
            .onions(true)
            .build()
    }

}