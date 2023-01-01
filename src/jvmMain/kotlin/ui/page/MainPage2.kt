package ui.page

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.constant.Global
import data.constant.Home
import data.`interface`.Selecter
import data.model.type.TypeView
import org.succlz123.lib.imageloader.ImageRes
import org.succlz123.lib.imageloader.core.ImageCallback
import ui.views.ViewDoctors
import ui.views.ViewNurse

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
@Preview
fun MainPage2(selecter: Selecter) {

    var position by remember { mutableStateOf(0) }

    MaterialTheme {
        Column {
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .padding(16.dp),
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                text = "Welcome to E-Health Care Management"
            )
            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(Home.data) {
                    Card(
                        modifier = Modifier.fillMaxWidth()
                            .padding(4.dp, 4.dp, 4.dp, 4.dp)
                            .height(160.dp),
                        backgroundColor = Color.White,
                        shape = RoundedCornerShape(16.dp),
                        elevation = 8.dp,
                        onClick = {
                            selecter.select(it.type)
//                            model = it
//                            show = it
                        }
                    ) {
                        Row {
                            Spacer(
                                modifier = Modifier.size(16.dp)
                            )
                            ImageRes(
                                resName = it.contact,
                                imageCallback = ImageCallback { painter ->
                                    Image(
                                        modifier = Modifier.size(100.dp)
                                            .clip(CircleShape)
                                            .align(
                                                alignment = Alignment.CenterVertically
                                            ),
                                        contentScale = ContentScale.Crop,
                                        painter = painter,
                                        contentDescription = "res"
                                    )
                                }
                            )

                            Column(
                                modifier = Modifier.align(
                                    alignment = Alignment.CenterVertically
                                ).padding(16.dp, 0.dp, 0.dp, 0.dp)
                            ) {
                                Text(
                                    text = it.title,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                                Spacer(modifier = Modifier.size(8.dp))
                                Text(
                                    text = it.subTitle,
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}