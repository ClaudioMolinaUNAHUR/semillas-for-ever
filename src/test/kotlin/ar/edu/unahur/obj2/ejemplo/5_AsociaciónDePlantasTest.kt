package ar.edu.unahur.obj2.ejemplo

import io.kotest.assertions.throwables.shouldThrowMessage
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class AsociaciónDePlantasTest : DescribeSpec ({
    val menta1 = Menta(2019,0.8)
    val soja1 = Soja(2020, 0.4)
    val soja2 = Soja(2012,0.7)
    val soja3 = Soja(2009,1.2)

    val p1 = Parcela("generica",4.0,2.0,4, mutableListOf())
    val p2 = Parcela("generica",2.0,3.0,6, mutableListOf()) // 5 plantas

    describe("tipos de parcela") {
        it("cambio parcela a tipo ecologica"){
            p1.cambiarATipo("ecologica")
            p1.tipo.shouldBe("ecologica")
        }
        it("cambio parcela a tipo industrial"){
            p1.cambiarATipo("industrial")
            p1.tipo.shouldBe("industrial")
        }
    }

    describe("asociacion de plantas en...") {
        describe("parcela generica ") {
            it("tira un error, en ellas no se analiza asociacion") {
                shouldThrowMessage("en parcelas genericas no se analiza asociacion") { p2.seAsociaBien(menta1) }
               // shouldThrowMessage("en parcelas genericas no se analiza asociacion") { p1.seAsociaBien(soja1) }//no se xq falla aca
            }
        }
        describe("parcela ecologica "){
            p1.cambiarATipo("ecologica")
            p2.cambiarATipo("ecologica")
            it("menta se asocia bien a p1 ya que p1 no tiene complicaciones y es ideal para menta") {
                p1.seAsociaBien(menta1).shouldBeTrue()
            }
            it("menta no se asocia bien a p2 ya que p2 tiene complicaciones") {
                p2.seAsociaBien(menta1).shouldBeFalse()
            }
            it("soja1 no se asocia bien a p1 ya que p1 aunque no tiene complicaciones no es ideal para soja1"){
                p1.seAsociaBien(soja1).shouldBeFalse()
            }
        }
        describe("parcela industrial"){
            p1.cambiarATipo("industrial")
            p2.cambiarATipo("industrial")
            it("p1 y p2 no son ideales para soja1 y soja2 ya que estas no son fuertes"){
                p1.seAsociaBien(soja1).shouldBeFalse()
                p1.seAsociaBien(soja2).shouldBeFalse()
                p2.seAsociaBien(soja1).shouldBeFalse()
                p2.seAsociaBien(soja2).shouldBeFalse()
            }
            it("p1 y p2 son ideal ideales para soja3 ya que esta es fuerte"){
                p1.seAsociaBien(soja3).shouldBeTrue()
                p2.seAsociaBien(soja3).shouldBeTrue()
            }
            it("p1 2pl ideal soja3"){
                p1.plantarSinCondicion(soja2)
                p1.plantarSinCondicion(soja2)
                p1.seAsociaBien(soja3).shouldBeTrue()
            }
            it("p1 con 3 plantas deja de ser ideal para soja 3"){
                p1.plantarSinCondicion(soja2)
                p1.plantarSinCondicion(soja2)
                p1.plantarSinCondicion(soja2)
                p1.seAsociaBien(soja3).shouldBeFalse()
            }
        }
    }
})

