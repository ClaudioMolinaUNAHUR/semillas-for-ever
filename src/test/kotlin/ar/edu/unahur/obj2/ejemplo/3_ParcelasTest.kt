package ar.edu.unahur.obj2.ejemplo

import io.kotest.assertions.throwables.shouldThrowMessage
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class ParcelasTest : DescribeSpec ({
    val soja1 = Soja(2009, 1.1)
    val soja2 = Soja(2009, 1.2)
    val soja3 = Soja(2009, 1.3)
    val soja4 = Soja(2009, 1.4)
    val soja5 = Soja(2009, 1.5)

    val parcelaA = Parcela(20.0,1.0,10, mutableListOf<Planta>(soja1,soja2,soja3,soja4))
    describe("parcela A, caracteristicas") {
        it("su superficie es de 20mts cuadrados") {
            parcelaA.superficie().shouldBe(20)
        }

        it("4 es su cant max de plantas"){
            parcelaA.cantMaxDePlantas().shouldBe(4)
        }

        it("verificamos si hay 4 plantas"){
            parcelaA.cantDePlantasEnParcela().shouldBe(4)
        }
        it("no tiene complicaciones") {
            parcelaA.tieneComplicaciones().shouldBeTrue()
        }
        it("no puede plantar ya que alcanso su maximo") {
            shouldThrowMessage("NO CUMPLE LA CONDICION PARA PLANTAR"){parcelaA.plantarUnaPlanta(soja5)}
        }
    }

})