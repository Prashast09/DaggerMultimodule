package ethens.network

import android.app.Application

object NetworkComponentFactory {
    fun provideNetowkrComponent(application: Application): NetworkComponent {
        return if (application is NetworkComonentProvider) {
            (application as NetworkComonentProvider).networkComonentProvider()
        } else {
            throw IllegalStateException("The application context you have passed does not implement CoreComponentProvider")
        }
    }
}