package ar.edu.unahur.obj2.ejemplo

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.shouldBe

class VariedadesTest : DescribeSpec ({
    describe("nacimiento de las sojas transgenicas") {
        val sojitaT = SojaTransgenica(2020, 0.4)
        val sojaT = SojaTransgenica(2012,0.8)
        val sojotaT = SojaTransgenica(2006,1.2)

        it("ocupan la mita de su altura, en metros cuadrados") {
            sojitaT.espacio().shouldBe(0.2)
            sojaT.espacio().shouldBe(0.4)
            sojotaT.espacio().shouldBe(0.6)
        }
        describe("nunca dan semillas") {
            sojitaT.daNuevasSemillas().shouldBeFalse()
            sojaT.daNuevasSemillas().shouldBeFalse()
            sojaT.daNuevasSemillas().shouldBeFalse()
        }

        describe("tolerancia al sol segun altura") {
            it("menos de 0.5mts - 6hs"){
                sojitaT.horasDeSolToleradas().shouldBe(6)
            }
            it("entre 0.5mts y 1 mts - 8hs"){
                sojaT.horasDeSolToleradas().shouldBe(8)
            }
            it("mas de 1 mts - 12hs"){
                sojotaT.horasDeSolToleradas().shouldBe(12)
            }
        }
    }

    describe("nacimiento de peperinas") {
        val menta = Menta(2021,1.0)
        val mentita = Menta(2021,0.3)

        val peperina1 = Peperina(2021,1.0)
        val peperina2 = Peperina(2021,0.3)

        describe(("peperina1")) {
            it("ocupa un espacio de 4m cuadrados el doble que una menta de iguales caracteristicas"){
                menta.espacio().shouldBe(2)
                peperina1.espacio().shouldBe(4)
            }
        }
        describe("peperina2") {
            it("ocupa un espacio de 2.6m cuadrados el doble que una menta de iguales caracteristicas"){
                mentita.espacio().shouldBe(1.3)
                peperina2.espacio().shouldBe(2.6)
            }
        }

    }
})