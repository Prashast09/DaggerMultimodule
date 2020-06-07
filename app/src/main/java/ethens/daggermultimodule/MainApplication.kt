package ethens.daggermultimodule

import android.app.Application
import ethens.network.DaggerNetworkComponent
import ethens.network.NetworkComonentProvider
import ethens.network.NetworkComponent


class MyApplication : Application(), NetworkComonentProvider {
    private lateinit var networkComponent: NetworkComponent

    override fun networkComonentProvider(): NetworkComponent {
        if(!::networkComponent.isInitialized)
            networkComponent =  DaggerNetworkComponent.builder().build()
        return networkComponent
    }

}