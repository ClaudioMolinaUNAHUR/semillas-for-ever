package ar.edu.unahur.obj2.ejemplo

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class ParcelasIdealesTest: DescribeSpec( {
    val parcela1 = Parcela(2.0,2.0,9, mutableListOf<Planta>())
    val parcela2 = Parcela(4.0,2.0,12, mutableListOf<Planta>())
    val parcela3 = Parcela(20.0,1.0,10, mutableListOf<Planta>())
    val parcela4 = Parcela(5.0,1.0,10, mutableListOf<Planta>())

    val menta = Menta(2021,1.0)
    val peperina = Peperina(2021,1.6)
    val quinoa = Quinoa(2006,1.0,0.9)
    val soja1 = Soja(2009, 0.8)
    val soja2 = Soja(2009, 1.5)
    val sojaT = SojaTransgenica(2012,0.8)

    describe("menta y analisis de parcela") {
        it("parcela 1 no es ideal para menta y peperina"){
            menta.esIdeal(parcela1).shouldBeFalse()
            peperina.esIdeal(parcela1).shouldBeFalse()
        }
        it("parcela 2 es ideal para menta y peperina"){
            menta.esIdeal(parcela2).shouldBeTrue()
            peperina.esIdeal(parcela2).shouldBeTrue()
        }
    }
    describe("quinoa analisis de parcela") {
        // agrego a parcela1 varias plantas, entre ellas una de 1.5
        it("parcela1 no es ideal ya que tiene una planta de 1.5mts en ella") {
            parcela3.plantarUnaPlanta(menta)
            parcela3.plantarUnaPlanta(peperina)
            quinoa.esIdeal(parcela3).shouldBeFalse()
        }

        it("parcela1 es parcela ideal al quitar la planta de 1.5") {
            parcela3.plantarUnaPlanta(menta)
            quinoa.esIdeal(parcela3).shouldBeTrue()
        }
    } //REVISAR
    describe("soja comun analisis de parcelas") {
        it("parcela2 es ideal para quinoa2") {
            soja2.esIdeal(parcela2).shouldBeTrue()
        }
        it("parcela1 no es ideal para quinoa2") {
            soja2.esIdeal(parcela1).shouldBeFalse()
        }
        it("ninguna de las parcela de prueba es ideal para soja1") {
            soja1.esIdeal(parcela1).shouldBeFalse()
            soja1.esIdeal(parcela2).shouldBeFalse()
            soja1.esIdeal(parcela3).shouldBeFalse()
            soja1.esIdeal(parcela4).shouldBeFalse()
        }
    }
    describe("soja transgenica analisis de parcela"){
        it("parcela4 es ideal ya que solo acepta una planta como maximo"){
            sojaT.esIdeal(parcela4).shouldBeTrue()
        }
        it("no son ideales las demas parcelas de prueba"){
            sojaT.esIdeal(parcela1).shouldBeFalse()
            sojaT.esIdeal(parcela2).shouldBeFalse()
            sojaT.esIdeal(parcela3).shouldBeFalse()
        }
    }
})