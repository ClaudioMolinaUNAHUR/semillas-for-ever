package ar.edu.unahur.obj2.ejemplo

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.roundToInt
import kotlin.math.roundToLong

object INTA {
    lateinit var parcelas : MutableSet<Parcela>
    fun promedioPlantasPorParcela() : Double {
        return (if(parcelas.size > 0) {
                    parcelas.sumByDouble { it.cantDePlantasEnParcela() } / parcelas.size.toDouble()
                }else{
                    0.0
                })
    }
    fun masSustentable() = parcelasSustentables().find{ c -> c.porcentajeBienAsociada() == parcelasSustentables().maxOf{c.porcentajeBienAsociada()}}
    fun parcelasSustentables() = parcelas.filter{ it.cantDePlantasEnParcela() > 4 }
}