package ethens.daggermultimodule

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ethens.daggermultimodule.di.DaggerAppComponent
import ethens.network.DaggerNetworkComponent
import ethens.network.NetworkComonentProvider
import ethens.network.NetworkComponent


class MyApplication : DaggerApplication(), NetworkComonentProvider {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
            .builder()
            .application(this)
            .networkComponent(networkComonentProvider())
            .build()
    }

    private lateinit var networkComponent: NetworkComponent

    override fun networkComonentProvider(): NetworkComponent {
        if (!::networkComponent.isInitialized)
            networkComponent = DaggerNetworkComponent.builder().build()
        return networkComponent
    }

}