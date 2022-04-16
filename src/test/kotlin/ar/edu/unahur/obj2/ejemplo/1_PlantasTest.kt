package ar.edu.unahur.obj2.ejemplo

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class SemillasTest : DescribeSpec ({
    /*describe("configuraciones planta base") {
        val planta = Planta(2021,1.0)
        it("la planta No es Fuerte"){
            planta.esFuerte().shouldBeFalse()
        }
        it("no da nuevas semillas"){
            planta.daNuevasSemillas().shouldBeFalse()
        }
    }*/
   describe("nacimiento de mentas") {
       val menta = Menta(2021,1.0)
       val mentita = Menta(2021,0.3)

       describe(("menta")) {
           it("da semillas") {
               menta.daNuevasSemillas().shouldBeTrue()
           }
           it("ocupa un espacio de 2m cuadrados"){
               menta.espacio().shouldBe(2)
           }
       }
       describe("mentita") {
           it("no da semillas") {
               mentita.daNuevasSemillas().shouldBeFalse()
           }
           it("ocupa un espacio de 1.3m cuadrados"){
               mentita.espacio().shouldBe(1.3)
           }
       }

   }

   describe("nacimiento de las sojas") {
       val sojita = Soja(2020, 0.4)
       val soja = Soja(2012,0.8)
       val sojota = Soja(2006,1.2)

       it("ocupan la mita de su altura, en metros cuadrados") {
           sojita.espacio().shouldBe(0.2)
           soja.espacio().shouldBe(0.4)
           sojota.espacio().shouldBe(0.6)
       }
       describe("dan semillas segun su condicion alternativa") {
           it("sojita por su altura no da semillas"){
               sojita.daNuevasSemillas().shouldBeFalse()
           }
           it("soja da semillas cumple solo sus condiciones"){
               soja.daNuevasSemillas().shouldBeTrue()
           }
           it("sojota da semillas aunque no cumple sus condiciones es fuerte"){
               soja.daNuevasSemillas().shouldBeTrue()
           }
       }
       describe("tolerancia al sol segun altura") {
           it("menos de 0.5mts - 6hs"){
               sojita.horasDeSolToleradas().shouldBe(6)
           }
           it("entre 0.5mts y 1 mts - 8hs"){
               soja.horasDeSolToleradas().shouldBe(8)
           }
           it("mas de 1 mts - 12hs"){
               sojota.horasDeSolToleradas().shouldBe(12)
           }
       }
   }

    describe("nacimiento de las quinoas") {
        val quinoita = Quinoa(2010,0.8,0.2)
        val quinoa = Quinoa(2006,1.0,0.9)

        describe("dan semillas por distintas condiciones") {
            it("quinoita x su altura tolera el sol(es fuerte)"){
                quinoita.daNuevasSemillas().shouldBeTrue()
            }
            it("quinoa x que cumple su condicion alternativa"){
                quinoa.daNuevasSemillas().shouldBeTrue()
            }
        }
        describe("horas de sol que tolera"){
            quinoa.horasDeSolToleradas().shouldBe(7)
            quinoita.horasDeSolToleradas().shouldBe(10)
        }
    }
})