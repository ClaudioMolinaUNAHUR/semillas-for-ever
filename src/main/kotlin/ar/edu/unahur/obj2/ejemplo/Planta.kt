package ar.edu.unahur.obj2.ejemplo

abstract class Planta(val anioDeObtencion: Int, val altura: Double) {
    open fun horasDeSolToleradas() = 7
    open fun esFuerte() = horasDeSolToleradas() > 9
    open fun daNuevasSemillas() = esFuerte() or condicionAlternativa()
    abstract fun condicionAlternativa(): Boolean
    abstract fun esIdeal(unaParcela: Parcela): Boolean

}

open class Menta(anioDeObtencion: Int, altura: Double) : Planta(anioDeObtencion, altura ) {
    open fun espacio() = altura + 1
    override fun condicionAlternativa() = altura > 0.4
    override fun esIdeal(unaParcela: Parcela) = unaParcela.superficie() > 6

}
class Peperina(anioDeObtencion: Int, altura: Double) : Menta(anioDeObtencion, altura ){
    override fun espacio() = super.espacio() * 2
}
open class Soja(anioDeObtencion: Int, altura: Double) : Planta(anioDeObtencion, altura ) {
    fun espacio() = altura/2

    override fun condicionAlternativa() =
        (anioDeObtencion > 2007) && altura in (0.75..0.9)

    override fun horasDeSolToleradas()=
        if(altura < 0.5) {6}
        else if(altura in (0.5..1.0)) {8}
        else {12}

    override fun esIdeal(unaParcela: Parcela) = unaParcela.horasDeSol == horasDeSolToleradas()
}

class SojaTransgenica(anioDeObtencion: Int, altura: Double) : Soja(anioDeObtencion, altura ){
    override fun daNuevasSemillas() = false

    override fun esIdeal(unaParcela: Parcela) = unaParcela.cantMaxDePlantas() == 1.0
}

class Quinoa(anioDeObtencion: Int, altura: Double, val espacio: Double) : Planta(anioDeObtencion, altura ) {
    override fun horasDeSolToleradas()= if(espacio < 0.3) {10} else {super.horasDeSolToleradas()}

    override fun condicionAlternativa() = anioDeObtencion in 2001..2008

    override fun esIdeal(unaParcela: Parcela) = unaParcela.listaDePlantas.all{ it.altura <= 1.5}

}