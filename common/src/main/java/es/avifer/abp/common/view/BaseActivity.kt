package es.avifer.abp.common.view

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import es.avifer.abp.common.extensions.hide
import es.avifer.abp.common.extensions.show
import es.avifer.abp.common.view.BaseActivity.Companion.URL_INTENT_MARKET
import es.avifer.abp.common.view.BaseActivity.Companion.URL_INTENT_PLAY_STORE

abstract class BaseActivity : ComponentActivity() {

    companion object {
        const val URL_INTENT_PLAY_STORE = "https://play.google.com/store/apps/details?id="
        const val URL_INTENT_MARKET = "market://details?id="
    }

    val versionName: String by lazy {
        try {
            packageManager.getPackageInfo(packageName, 0).versionName
        } catch (e: Exception) {
            ""
        }
    }

}

fun BaseActivity.toast(
    @StringRes idString: Int,
    duration: Int = Toast.LENGTH_SHORT
) {
    Toast.makeText(
        this,
        getString(idString),
        duration
    ).show()
}

fun BaseActivity.openAppInGooglePlay() {
    try {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(URL_INTENT_MARKET + packageName)
            )
        )
    } catch (e: ActivityNotFoundException) {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(URL_INTENT_PLAY_STORE + packageName)
            )
        )
    }
}