package ethens.daggermultimodule.di

import dagger.Module
import dagger.Provides
import ethens.daggermultimodule.AppObject

@Module
class AppModule {
    @Provides
    fun provideAppObject() = AppObject()
}