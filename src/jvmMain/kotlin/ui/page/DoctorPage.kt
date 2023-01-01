package ui.page

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.window.Dialog
import data.constant.App
import data.constant.Global
import data.`interface`.Selecter
import data.model.ModelDoctor
import data.model.type.TypeDoctor
import data.model.type.TypeView
import org.succlz123.lib.imageloader.ImageRes
import org.succlz123.lib.imageloader.core.ImageCallback

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
@Preview
fun DoctorPage(selector: Selecter) {

    var show by remember { mutableStateOf<ModelDoctor?>(null) }

    var model by remember {
        mutableStateOf(
            ModelDoctor(TypeDoctor.TITLE, "", "", "")
        )
    }

    val data = remember { mutableStateListOf<ModelDoctor>() }

    MaterialTheme {
        Column (
            modifier = Modifier.fillMaxSize()
        ) {
            Row {
                ImageRes(
                    resName = "back.png",
                    imageCallback = ImageCallback { painter ->
                        Image(
                            modifier = Modifier.size(52.dp)
                                .padding(12.dp)
                                .clip(CircleShape)
                                .clickable {
                                    selector.select(TypeView.MAIN)
                                },
                            painter = painter,
                            contentDescription = "res",
                        )
                    }
                )
                Text(
                    text = "Doctors",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }

            LazyColumn(
                contentPadding = PaddingValues(16.dp)
            ) {
                items(data) {
                    if (it.type == TypeDoctor.TITLE)
                        Text(
                            text = it.title,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(0.dp, 12.dp),
                        )
                    else {
                        Card(
                            modifier = Modifier.fillMaxWidth()
                                .padding(0.dp, 0.dp, 0.dp, 8.dp)
                                .height(100.dp),
                            backgroundColor = Color.White,
                            shape = RoundedCornerShape(16.dp),
                            elevation = 8.dp,
                            onClick = {
                                model = it
                                show = it
                            }
                        ) {
                            Row {
                                Spacer(
                                    modifier = Modifier.size(16.dp)
                                )
                                ImageRes(
                                    resName = "doctor_2.jpeg",
                                    imageCallback = ImageCallback { painter ->
                                        Image(
                                            modifier = Modifier.size(60.dp)
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
                                        text = "Contact: ${it.contact}",
                                        fontSize = 16.sp,
                                        textAlign = TextAlign.Center
                                    )
                                }
                                if (Global.bookDoc.contains(it)) {
                                    Column(
                                        modifier = Modifier.fillMaxWidth()
                                            .align(Alignment.CenterVertically)
                                    ) {
                                        ImageRes(
                                            resName = "check.png",
                                            imageCallback = ImageCallback { painter ->
                                                Image(
                                                    modifier = Modifier.size(60.dp)
                                                        .padding(20.dp)
                                                        .clip(CircleShape)
                                                        .align(
                                                            alignment = Alignment.End
                                                        ),
                                                    contentScale = ContentScale.Crop,
                                                    painter = painter,
                                                    contentDescription = "res"
                                                )
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (show != null) {
                Dialog(
                    { show = null },
                    title = "Doctors Info",
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Spacer(modifier = Modifier.size(20.dp))
                        ImageRes(
                            resName = "hospital.png",
                            imageCallback = ImageCallback { painter ->
                                Image(
                                    modifier = Modifier.size(80.dp)
                                        .clip(CircleShape)
                                        .align(
                                            alignment = Alignment.CenterHorizontally
                                        ),
                                    contentScale = ContentScale.Crop,
                                    painter = painter,
                                    contentDescription = "res"
                                )
                            }
                        )
                        Spacer(modifier = Modifier.size(12.dp))
                        Text(
                            "Name: ${model.title}",
                            modifier = Modifier.padding(24.dp, 0.dp, 0.dp, 0.dp)
                        )
                        Spacer(modifier = Modifier.size(6.dp))
                        Text(
                            "Degree: MBBS, FCPS",
                            modifier = Modifier.padding(24.dp, 0.dp, 0.dp, 0.dp)
                        )
                        Spacer(modifier = Modifier.size(6.dp))
                        Text(
                            "Visiting Hour: 1:00PM - 5:00PM",
                            modifier = Modifier.padding(24.dp, 0.dp, 0.dp, 0.dp)
                        )
                        Spacer(modifier = Modifier.size(6.dp))
                        Text(
                            "Hospital: Green Hospital, Dhaka",
                            modifier = Modifier.padding(24.dp, 0.dp, 0.dp, 0.dp)
                        )
                        Spacer(modifier = Modifier.size(6.dp))
                        Button(
                            onClick = {
                                if (!Global.bookDoc.contains(show)) {
                                    Global.bookDoc.add(show!!)
                                    show = null
                                }
                            },
                            modifier = Modifier.align(Alignment.End)
                                .padding(0.dp, 0.dp, 24.dp, 0.dp)
                        ) {
                            Text("Get Appointment")
                        }
                    }
                }
            }
            data.clear()
            data.addAll(App.dataDoctor)
        }
    }
}