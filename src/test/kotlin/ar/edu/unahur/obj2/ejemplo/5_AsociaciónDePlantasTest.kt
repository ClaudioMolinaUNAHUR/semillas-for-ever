package ar.edu.unahur.obj2.ejemplo

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class AsociaciónDePlantasTest : DescribeSpec ({
    val menta1 = Menta(2019,0.8)

    val soja1 = Soja(2020, 0.4)
    val soja2 = Soja(2012,1.1)
    val soja3 = Soja(2006,1.2)
    val soja4 = Soja(2015,1.1)
    val soja5 = Soja(2009,1.2)


    val parcelaEco = ParcelaEcologica(4.0,2.0,4, mutableListOf())
    val parcelaEco2 = ParcelaEcologica(4.0,1.0,4, mutableListOf())
    val parcelaInd = ParcelaIndustrial(6.0,2.0,4, mutableListOf())

    describe("parcel ecologica con menta"){
        it("parcelaEco se asocia bien a menta" ){
            parcelaEco.seAsociaBienA(menta1).shouldBeTrue()
        }
        it("parcelaEco2 no se asocia bien a menta" ){
            parcelaEco2.seAsociaBienA(menta1).shouldBeFalse()
        }
    }
    describe("parcel industrial con sojas") {
        it("parcelaInd no se asocia bien a menta ya que no es fuerte") {
            parcelaInd.seAsociaBienA(menta1).shouldBeFalse()
        }
        it("parcelaInd se asociabien con soja2 y soja3, son fuerte y no tiene mas de dos plantas"){
            parcelaInd.seAsociaBienA(soja2).shouldBeTrue()
            parcelaInd.seAsociaBienA(soja3).shouldBeTrue()
        }
        it("parcelaInd ya no se asocia con soja2 soja3 ya que tiene dos plantas"){
            parcelaInd.plantarSinCondicion(soja4)
            parcelaInd.plantarSinCondicion(soja5)
            parcelaInd.seAsociaBienA(soja2).shouldBeFalse()
            parcelaInd.seAsociaBienA(soja3).shouldBeFalse()
        }
        it("parcelaInd no se asocia con soja1, es debil") {
            parcelaInd.seAsociaBienA(soja1).shouldBeFalse()
        }

    }
})

