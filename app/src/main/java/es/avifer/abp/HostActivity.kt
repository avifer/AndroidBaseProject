package es.avifer.abp

import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.constraintlayout.widget.ConstraintLayout
import dagger.hilt.android.AndroidEntryPoint
import es.avifer.abp.common.theme.MyApplicationTheme
import es.avifer.abp.common.view.BaseActivity
import es.avifer.abp.common.view.toast
import es.avifer.abp.feature.splash.ui.view.Splash

@AndroidEntryPoint
class HostActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Splash()
                }
            }
        }
        toast(R.string.app_name)
    }

}