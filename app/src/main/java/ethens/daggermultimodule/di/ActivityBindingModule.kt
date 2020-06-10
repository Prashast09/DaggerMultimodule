package ethens.daggermultimodule.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ethens.daggermultimodule.MainActivity
import ethens.featuremodule.FeatureActivity
import ethens.featuremodule.di.FeatureModule

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [FeatureModule::class])
    abstract fun featureActivity(): FeatureActivity
}