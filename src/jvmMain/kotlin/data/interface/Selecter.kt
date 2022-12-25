package data.`interface`

import data.model.type.TypeView

interface Selecter {
    fun select(typeView: TypeView)
}