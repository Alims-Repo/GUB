package data.model

import data.model.type.TypeDoctor

data class ModelDoctor(
    val type: TypeDoctor,
    val title: String,
    val subTitle: String,
    val contact: String,
    var checked: Boolean = false
)