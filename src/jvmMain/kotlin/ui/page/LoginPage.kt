package ui.page

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.constant.Global
import data.`interface`.Selecter
import data.model.ModelUser
import data.model.type.TypeView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun LoginPage(selecter: Selecter) {

    var loading by remember { mutableStateOf(false) }
    var snack by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("sourab.0.alim@gmail.com") }
    var password by remember { mutableStateOf("password") }

    MaterialTheme {

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.align(
                    Alignment.Center
                )
            ) {
                Text(
                    text = "Enter your credentials",
                    fontSize = 16.sp,
//                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.size(16.dp))
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = { Text(text = "Enter your email") },
                )
                Spacer(modifier = Modifier.size(16.dp))
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = { Text(text = "Enter your password") },
                )
                Spacer(modifier = Modifier.size(16.dp))
                Button(
                    onClick = {
                        snack = ""
                        loading = true
                        CoroutineScope(Dispatchers.IO).launch {
                            delay(2000)
                            if (email.isBlank())
                                snack = "Enter your email"
                            if(email.isNotBlank() && password.isNotBlank()) {
                                Global.userData = ModelUser(
                                    "Abdul Alim",
                                    email, password
                                )
                                selecter.select(TypeView.MAIN)
                            }
                            loading = false
                        }
                    },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Login")
                }
                Spacer(modifier = Modifier.size(16.dp))
                if (loading)
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
            }
        }
    }

    if(snack.isNotEmpty()) {
        Snackbar(
            modifier = Modifier.padding(8.dp)
        ) { Text(text = snack) }
    }
}