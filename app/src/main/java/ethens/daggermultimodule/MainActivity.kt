package ethens.daggermultimodule

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.android.support.DaggerAppCompatActivity
import ethens.featuremodule.FeatureActivity
import ethens.network.NetworkObject
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var networkObject : NetworkObject

    @Inject
    lateinit var appObject : AppObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_object.text = appObject.appText
        network_object.text = networkObject.network

        button.setOnClickListener {

            val intent = Intent(this, FeatureActivity::class.java)
            startActivity(intent)
        }

    }
}
