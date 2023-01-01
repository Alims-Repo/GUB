package data.constant

import data.model.ModelDoctor
import data.model.ModelHome
import data.model.type.TypeDoctor
import data.model.type.TypeView

object Home {
    val data = ArrayList<ModelH>().also {
        it.add(ModelH(TypeView.HOSPITAL, "Hospitals", "27 Hospitals", "hospital.png"))
        it.add(ModelH(TypeView.DOCTOR, "Doctors", "319 Doctors", "doctor_2.jpeg"))
        it.add(ModelH(TypeView.REPORT, "Reports", "3 Reports", "birth_report.png"))
        it.add(ModelH(TypeView.APPOINTMENTS, "Appointments", "No Appointsments", "appointment.jpg"))
    }
}

data class ModelH(
    val type: TypeView,
    val title: String,
    val subTitle: String,
    val contact: String,
    var checked: Boolean = false
)