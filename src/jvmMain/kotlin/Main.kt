import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data.`interface`.Selecter
import data.model.type.TypeView
import ui.page.LoginPage
import ui.page.MainPage
import ui.page.MyAppoinments
import ui.page.SplashPage

fun main() = application {
    var type by remember { mutableStateOf(TypeView.SPLASH) }
    Window(
        title = "E-Health Care",
        resizable = false,
        onCloseRequest = ::exitApplication
    ) {
        when(type) {
            TypeView.SPLASH -> {
                SplashPage(
                    object : Selecter {
                        override fun select(typeView: TypeView) {
                            type = typeView
                        }
                    }
                )
            }
            TypeView.LOGIN -> {
                LoginPage(
                    object : Selecter {
                        override fun select(typeView: TypeView) {
                            type = typeView
                        }
                    }
                )
            }
            TypeView.MAIN -> {
                MainPage(
                    object : Selecter {
                        override fun select(typeView: TypeView) {
                            type = typeView
                        }
                    }
                )
            }

            TypeView.BOOKING -> {
                MyAppoinments(
                    object : Selecter {
                        override fun select(typeView: TypeView) {
                            type = typeView
                        }
                    }
                )
            }
        }
    }
}
