package ethens.network

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton


@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideNetworkObject()  = NetworkObject()
}