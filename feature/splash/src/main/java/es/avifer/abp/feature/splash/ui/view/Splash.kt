package es.avifer.abp.feature.splash.ui.view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import es.avifer.abp.common.theme.MyApplicationTheme

@Composable
fun Splash() {
    Text(
        text = "HOLA"
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Splash()
    }
}