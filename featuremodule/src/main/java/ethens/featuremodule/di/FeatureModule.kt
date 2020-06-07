package ethens.featuremodule.di

import dagger.Module
import dagger.Provides


@Module
class FeatureModule {
    @Provides
    fun provideFeatureText() = "I'm Feature Text"
}