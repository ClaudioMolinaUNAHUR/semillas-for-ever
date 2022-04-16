package ar.edu.unahur.obj2.ejemplo

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class INTA(var parcelas : MutableCollection<Parcela>) {
    fun promedioPlantasPorParcela() : Double {
        return parcelas.sumByDouble{ it.cantDePlantasEnParcela() } / parcelas.size.toDouble()
    }
    fun masSustentable() = parcelasSustentables().find{ c -> c.porcentajeBienAsociada() == parcelasSustentables().maxOf{c.porcentajeBienAsociada()}}
    fun parcelasSustentables() = parcelas.filter{ it.cantDePlantasEnParcela() >= 4 }
}