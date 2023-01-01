import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data.`interface`.Selecter
import data.model.type.TypeView
import ui.page.*

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
                MainPage2(
                    object : Selecter {
                        override fun select(typeView: TypeView) {
                            type = typeView
                        }
                    }
                )
            }

            TypeView.BOOKING -> {
                MyAppointments(
                    object : Selecter {
                        override fun select(typeView: TypeView) {
                            type = typeView
                        }
                    }
                )
            }
            // New Attachments
            TypeView.HOSPITAL -> {
                HospitalPage(
                    object : Selecter {
                        override fun select(typeView: TypeView) {
                            type = typeView
                        }
                    }
                )
            }
            TypeView.DOCTOR -> {
                DoctorPage(
                    object : Selecter {
                        override fun select(typeView: TypeView) {
                            type = typeView
                        }
                    }
                )
            }
            TypeView.REPORT -> {
                ReportPage(
                    object : Selecter {
                        override fun select(typeView: TypeView) {
                            type = typeView
                        }
                    }
                )
            }
            TypeView.APPOINTMENTS -> {
                MyAppointments(
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
