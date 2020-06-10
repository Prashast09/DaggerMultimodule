package ethens.daggermultimodule.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ethens.daggermultimodule.MyApplication
import ethens.network.NetworkComponent

@Component(modules = [AppModule::class,
    ActivityBindingModule::class,
    AndroidSupportInjectionModule::class],
    dependencies = [NetworkComponent::class]
)
@AppScope
interface AppComponent : AndroidInjector<MyApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): AppComponent.Builder
        fun networkComponent(networkComponent: NetworkComponent): AppComponent.Builder
        fun build(): AppComponent
    }
}