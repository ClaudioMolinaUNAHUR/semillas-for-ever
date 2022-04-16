package ar.edu.unahur.obj2.ejemplo

import kotlin.math.ceil

open class Parcela(var ancho: Double, var largo: Double, val horasDeSol: Int, val listaDePlantas: MutableList<Planta>) {
    fun superficie() = ancho * largo

    fun cantMaxDePlantas() = ceil(if(ancho > largo) {superficie()/5} else {superficie()/3 + largo})

    fun cantDePlantasEnParcela() = listaDePlantas.size.toDouble()

    fun plantarSinCondicion(unaPlanta: Planta) = listaDePlantas.add(unaPlanta)

    fun plantarUnaPlanta(unaPlanta: Planta) =
        if (condicionParaPlantar(unaPlanta)){
            listaDePlantas.add(unaPlanta)
        }else{
            error("NO CUMPLE LA CONDICION PARA PLANTAR")
        }

    fun quitar(unaPlanta: Planta) = listaDePlantas.remove(unaPlanta)

    fun condicionParaPlantar(unaPlanta: Planta) = cantMaxDePlantas() < cantDePlantasEnParcela() || horasDeSol > unaPlanta.horasDeSolToleradas()+2

    fun tieneComplicaciones() = listaDePlantas.any{ it.horasDeSolToleradas() > horasDeSol}

    open fun seAsociaBienA(unaPlanta: Planta) = false

    fun porcentajeBienAsociada() = listaDePlantas.count{n ->this.seAsociaBienA(n)} / listaDePlantas.size * 100.0

}
class ParcelaEcologica(ancho: Double, largo: Double, horasDeSol: Int, listaDePlantas: MutableList<Planta>) : Parcela(ancho, largo,horasDeSol,listaDePlantas){
    override fun seAsociaBienA(unaPlanta: Planta) = !tieneComplicaciones() && unaPlanta.esIdeal(this)
}

class ParcelaIndustrial(ancho: Double, largo: Double, horasDeSol: Int, listaDePlantas: MutableList<Planta>) : Parcela(ancho, largo,horasDeSol,listaDePlantas){
    override fun seAsociaBienA(unaPlanta: Planta) = listaDePlantas.size < 2 && unaPlanta.esFuerte()
}
