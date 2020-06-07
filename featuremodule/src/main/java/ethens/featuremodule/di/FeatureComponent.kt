package ethens.featuremodule.di

import dagger.Component
import ethens.featuremodule.FeatureActivity
import ethens.network.NetworkComponent


@Component(modules = [FeatureModule::class], dependencies = [NetworkComponent::class])
@FeatureScope
interface FeatureComponent {
    fun inject(featureActivity: FeatureActivity)
}