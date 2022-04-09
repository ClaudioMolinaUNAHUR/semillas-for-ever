package ar.edu.unahur.obj2.ejemplo

class Parcela(var ancho: Int, var largo: Int, var horasDeSol: Int, var listPlantas : MutableList<Planta>){
    fun superficie(): Int{
        return ancho * largo
    }
    fun agregarPlanta(unaPlanta: Planta) {
        listPlantas.add(unaPlanta)
    }
    fun cantidadMaximaTolerada() = if (ancho> largo) {superficie()/5} else {superficie()/3 + largo}
    fun tieneComplicaciones() = listPlantas.any{n:Planta -> n.horasDeSolTolera() > horasDeSol}
    fun plantar(unaPlanta: Planta){
        if (cantidadMaximaTolerada() < listPlantas.size || unaPlanta.horasDeSolTolera() < horasDeSol+2){
            agregarPlanta(unaPlanta)
        }
        else{
            throw Exception("Se supero la cantidad de Plantas o le falta Sol")
        }
    }
}


