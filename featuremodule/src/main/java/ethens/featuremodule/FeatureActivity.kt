package ethens.featuremodule

import android.app.Activity
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import ethens.network.NetworkObject
import kotlinx.android.synthetic.main.activity_feature.*
import javax.inject.Inject

class FeatureActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var networkData: NetworkObject

    @Inject
    lateinit var featureObject : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature)
        initView()
    }

    private fun initView() {
        network_tv.text = networkData.network
        text.text = featureObject
    }


}