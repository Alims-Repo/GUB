package data.constant

import data.model.ModelDoctor
import data.model.ModelHome
import data.model.type.TypeDoctor

object App {

    val dataHome = listOf(
        ModelHome(0, "Doctors", "58", "doc.png"),
        ModelHome(1, "Nurse", "328", "nurse.png"),
        ModelHome(2, "Pharmacist", "65", "pharmacy.jpg"),
        ModelHome(3, "Birth Report", "958", "birth_report.png"),
        ModelHome(4, "Death Report", "108", "death_report.png"),
        ModelHome(5, "My Appointments", "0", "appointment.jpg")
    )

    val dataDoctor = ArrayList<ModelDoctor>().also {
        it.add(ModelDoctor(TypeDoctor.TITLE, "Medicine", "", "+8801881632597"))
        it.add(ModelDoctor(TypeDoctor.INFO, "Dr. Alim", "", "+8801881632597"))
        it.add(ModelDoctor(TypeDoctor.INFO, "Dr. Sourav", "", "+8801881632597"))
        it.add(ModelDoctor(TypeDoctor.INFO, "Dr. Zabaar", "", "+8801881632597"))
        it.add(ModelDoctor(TypeDoctor.TITLE, "Orthopedic", "", "+8801881632597"))
        it.add(ModelDoctor(TypeDoctor.INFO, "Dr. Adit", "", "+8801881632597"))
        it.add(ModelDoctor(TypeDoctor.INFO, "Dr. Sakib", "", "+8801881632597"))
        it.add(ModelDoctor(TypeDoctor.INFO, "Dr. Nasir", "", "+8801881632597"))
    }

    val dataHospital = ArrayList<ModelDoctor>().also {
        it.add(ModelDoctor(TypeDoctor.TITLE, "Hospital Nearby", "", "+8801881632597"))
        it.add(ModelDoctor(TypeDoctor.INFO, "Popular", "", "+8801881632597"))
        it.add(ModelDoctor(TypeDoctor.INFO, "Evercare", "", "+8801881632597"))
        it.add(ModelDoctor(TypeDoctor.INFO, "Lab Aid", "", "+8801881632597"))
        it.add(ModelDoctor(TypeDoctor.INFO, "Square", "", "+8801881632597"))
        it.add(ModelDoctor(TypeDoctor.TITLE, "Best Ratings", "", "+8801881632597"))
        it.add(ModelDoctor(TypeDoctor.INFO, "United", "", "+8801881632597"))
        it.add(ModelDoctor(TypeDoctor.INFO, "BRB Hospital", "", "+8801881632597"))
        it.add(ModelDoctor(TypeDoctor.INFO, "Dhaka Medical College", "", "+8801881632597"))
        it.add(ModelDoctor(TypeDoctor.INFO, "Mitford Hospital", "", "+8801881632597"))
    }

    val dataReport = ArrayList<ModelDoctor>().also {
        it.add(ModelDoctor(TypeDoctor.TITLE, "Blood Test", "", "+8801881632597"))
        it.add(ModelDoctor(TypeDoctor.INFO, "X Test", "", "Positive"))
        it.add(ModelDoctor(TypeDoctor.TITLE, "Urine Test", "", "+8801881632597"))
        it.add(ModelDoctor(TypeDoctor.INFO, "Y Test", "", "Negative"))
    }
}