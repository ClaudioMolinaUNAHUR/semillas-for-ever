package ar.edu.unahur.obj2.ejemplo

import kotlin.math.ceil

open class Parcela(var tipo:String= "generico", var ancho: Double, var largo: Double, val horasDeSol: Int, val listaDePlantas: MutableList<Planta>) {
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

    //open fun seAsociaBienA(unaPlanta: Planta) = false
    fun cambiarATipo(unTipo: String)= unTipo.also { this.tipo = it }

    fun seAsociaBien(unaPlanta: Planta) :Boolean {
        var resultado:Boolean
        if (tipo == "ecologica") {
            resultado = !tieneComplicaciones() && unaPlanta.esIdeal(this)
        }else if(tipo == "industrial") {
            resultado = cantDePlantasEnParcela() <= 2 && unaPlanta.esFuerte()
        }else{
            error("en parcelas genericas no se analiza asociacion")
        }
        return resultado
    }

    fun porcentajeBienAsociada(): Double {
        if(listaDePlantas.size  == 0) return 0.0
        return listaDePlantas.count{n ->this.seAsociaBien(n)} / listaDePlantas.size * 100.0
    }

}
