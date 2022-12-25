package ui.page

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.constant.Global
import data.`interface`.Selecter
import data.model.type.TypeView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.succlz123.lib.imageloader.ImageRes
import org.succlz123.lib.imageloader.core.ImageCallback

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun SplashPage(selecter: Selecter) {

    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.align(Alignment.Center)
            ) {
                ImageRes(
                    resName = "splash.png",
                    imageCallback = ImageCallback { painter ->
                        Image(
                            modifier = Modifier.size(300.dp)
                                .align(Alignment.CenterHorizontally),
                            painter = painter,
                            contentDescription = "res"
                        )
                    }
                )
                Spacer(modifier = Modifier.size(32.dp))
                Row(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = "E-Health Care",
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    CircularProgressIndicator(
                        modifier = Modifier.size(16.dp)
                            .align(Alignment.CenterVertically),
                        strokeWidth = 2.dp
                    )
                }
            }
        }
    }

    CoroutineScope(Dispatchers.IO).launch {
        delay(2000)
        selecter.select(
            if (Global.userData == null)
                TypeView.LOGIN
            else TypeView.MAIN
        )
    }
}