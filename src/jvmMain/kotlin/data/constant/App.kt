package data.constant

import model.ModelDoctor
import model.ModelHome
import model.type.TypeDoctor

object App {

    val dataHome = listOf(
        ModelHome(0, "Doctors", "58", "doc.png"),
        ModelHome(1, "Nurse", "328", "nurse.png"),
        ModelHome(2, "Pharmacist", "65", "pharmacy.jpg"),
        ModelHome(3, "Birth Report", "958", "birth_report.png"),
        ModelHome(4, "Death Report", "108", "death_report.png")
    )

    val dataDoctor = listOf(
        ModelDoctor(TypeDoctor.TITLE, "Medicine", "", "+8801881632597"),
        ModelDoctor(TypeDoctor.INFO, "Dr. Alim", "", "+8801881632597"),
        ModelDoctor(TypeDoctor.INFO, "Dr. Sourav", "", "+8801881632597"),
        ModelDoctor(TypeDoctor.INFO, "Dr. Zabaar", "", "+8801881632597"),
        ModelDoctor(TypeDoctor.TITLE, "Orthopedic", "", "+8801881632597"),
        ModelDoctor(TypeDoctor.INFO, "Dr. Adit", "", "+8801881632597"),
        ModelDoctor(TypeDoctor.INFO, "Dr. Sakib", "", "+8801881632597"),
        ModelDoctor(TypeDoctor.INFO, "Dr. Nasir", "", "+8801881632597"),
    )
}