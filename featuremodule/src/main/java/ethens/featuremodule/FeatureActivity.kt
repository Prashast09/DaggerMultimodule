package ethens.featuremodule

import android.app.Activity
import android.os.Bundle
import ethens.featuremodule.di.DaggerFeatureComponent
import ethens.network.NetworkComponentFactory
import ethens.network.NetworkObject
import kotlinx.android.synthetic.main.activity_feature.*
import javax.inject.Inject

class FeatureActivity : Activity() {

    @Inject
    lateinit var networkData: NetworkObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDagger()
        setContentView(R.layout.activity_feature)
        initView()
    }

    private fun initDagger() {
        DaggerFeatureComponent.builder()
            .networkComponent(NetworkComponentFactory.provideNetowkrComponent(application)).build()
            .inject(this)
    }

    private fun initView() {
        network_tv.text = networkData.network
    }


}