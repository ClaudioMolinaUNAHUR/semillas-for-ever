package ar.edu.unahur.obj2.ejemplo

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class IntaTest : DescribeSpec ({
    val soja1 = Soja(2009, 1.1)
    val soja2 = Soja(2009, 1.2)
    val soja3 = Soja(2009, 1.3)
    val soja4 = Soja(2009, 1.4)
    val parcelaA = ParcelaEcologica(20.0,1.0,10, mutableListOf<Planta>(soja1,soja2,soja3))
    val parcelaB = ParcelaEcologica(20.0,1.0,10, mutableListOf<Planta>(soja1,soja2,soja3,soja4))
    val parcelaC = ParcelaIndustrial(20.0,1.0,10, mutableListOf<Planta>(soja1,soja2,soja3,soja4,soja1,soja2))
    val inta = INTA(mutableSetOf(parcelaA, parcelaB, parcelaC))
    describe("parcelasSustentables"){
        it("parcelaB y C"){
            inta.parcelasSustentables().shouldBe(listOf(parcelaB,parcelaC))
        }
        it("mas sustentable"){
            inta.masSustentable().shouldBe(parcelaB)
        }
        it("no son sustentables A y C"){
            inta.masSustentable().shouldNotBe(parcelaA)
            inta.masSustentable().shouldNotBe(parcelaC)
        }
    }
    describe ("promedioPlantasPorParcela") {
        it("promedio Parcela A B y C") {
            inta.promedioPlantasPorParcela().shouldBe(4.33)
            parcelaA.plantarSinCondicion(soja3)
            inta.promedioPlantasPorParcela().shouldBe(4.67)
        }
    }
})