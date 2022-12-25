package ui.page

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.`interface`.Selecter
import data.model.type.TypeView
import org.succlz123.lib.imageloader.ImageRes
import org.succlz123.lib.imageloader.core.ImageCallback
import ui.views.ViewDoctors
import ui.views.ViewNurse

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun MainPage(selecter: Selecter) {

    var position by remember { mutableStateOf(0) }

    MaterialTheme {
        Row (
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                contentPadding = PaddingValues(4.dp)
            ) {
                items(data.constant.App.dataHome) {
                    Card(
                        modifier = Modifier.padding(4.dp)
                            .width(110.dp),
                        backgroundColor = if (position == it.id) Color.Green else Color.White,
                        shape = RoundedCornerShape(8.dp),
                        elevation = 8.dp,
                        onClick = {
                            position = it.id
                            if (it.id == 5) selecter.select(TypeView.BOOKING)
                        }
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.size(8.dp))
                            ImageRes(
                                resName = it.img,
                                imageCallback = ImageCallback { painter ->
                                    Image(
                                        modifier = Modifier.size(44.dp),
                                        painter = painter,
                                        contentDescription = "res"
                                    )
                                }
                            )
                            Spacer(modifier = Modifier.size(8.dp))
                            Text(
                                text = it.title,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.size(8.dp))
                        }
                    }
                }
            }
            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(0.dp, 8.dp)
                    .width(2.dp)
            )
            when(position) {
                0 -> ViewDoctors()
                1 -> ViewNurse()
                2 -> ViewDoctors()
                3 -> ViewDoctors()
                4 -> ViewDoctors()
                5 -> ViewDoctors()
                6 -> ViewDoctors()
                7 -> ViewDoctors()
                8 -> ViewDoctors()
            }

        }
    }
}