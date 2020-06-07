# DaggerMultimodule

Steps : 

#### Feature Component
- Each feature module will consist of its own Component + Module + Scope
- These feature might depend on certain entities like (database , network, local storage, etc). To include such dependencies we'll add DatabaseComponent, NetworkComponent, XComponent as depencies in FeatureComponent.
- When a dependency is added to feature component, feature component will be the one supplying the dependent component ( CoreComponent). How? Check Dependency Factory
- Why scoping is important for features? Check FAQ

~~~ 
@Component(modules = [FeatureModule::class], dependencies = [NetworkComponent::class])
@FeatureScope
interface FeatureComponent {
    fun inject(featureActivity: FeatureActivity)
}
~~~

#### Core Component (Network, Database, SharePref Components)
- These can be Network, Database, SharePref, etc. They will consist of their own Component + Module ( No Scope ).
- All dependencies from such components are usually consumed throughout the lifecycle of the application. So components are marked @Singleton, such that object is created only once per app lifecycle.
~~~
@Component(modules = [NetworkModule::class])
@Singleton
interface NetworkComponent {
    fun getNetworkObject(): NetworkObject
}
~~~

#### Dependency Factory
- Since Core Component are to be created with @Singleton scoping, they should be binded to applicationContext. 
- We create a class CoreComponentFactory(creating coreComponent at application level) & an interface CoreComponentProvider (implemented by class to which component is to be binded).
- Application extends and implements CoreComponentProvider.
- [IMP]Why all this is needed? Since FeatureComponent have to supply CoreComponent, application class has to implement above classes.

        DaggerFeatureComponent.builder()
            .networkComponent(NetworkComponentFactory.provideNetowkrComponent(application)).build()
            .inject(this)






##### FAQ
1. Why Scope is required in FeatureComponent?
We know FeatureComponent depends on CoreComponents which are singleton & since dagger does not allow unscoped components to depend on scoped component, we'll have to create separate FeatureScope for each feature.

2. Use @Singleton scope for FeatureComponent then?
Dagger does not allow same scoped components to depend on each other.




