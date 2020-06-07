package ethens.network

import dagger.Module
import dagger.Provides
import javax.inject.Named


@Module
class NetworkModule {

    @Provides
    fun provideNetworkObject()  = NetworkObject()
}