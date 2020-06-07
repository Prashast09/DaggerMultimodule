package ethens.network

import dagger.Component
import javax.inject.Singleton


@Component(modules = [NetworkModule::class])
@Singleton
interface NetworkComponent {
    fun getNetworkObject(): NetworkObject
}