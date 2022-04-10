package ar.edu.unahur.obj2.ejemplo

import io.kotest.assertions.throwables.shouldThrowMessage
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.doubles.shouldBeBetween
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import ar.edu.unahur.obj2.ejemplo.Quinoa as Quinoa1

class PlantasTest: DescribeSpec( {
    //ETAPA 1
    // hay clase Planta que tiene por atributos: año Semilla, altura
    describe(name="Creacion de mentas") {
        // altura, año
        val menta = Menta(2021, 1.0)
        val mentita = Menta(2021, 0.3)

        it("Los atributos funcionan") {
            menta.altura.shouldBe(1.0)
            menta.anioSemilla.shouldBe(2021)
        }
        it("dan semillas") {
            menta.daSemilla().shouldBeTrue()
            mentita.daSemilla().shouldBeFalse()
        }
        it("espacio") {
            menta.espacio().shouldBe(2.0)
            mentita.espacio().shouldBe(1.3)
        }
    }

    describe("creacion de soja"){
        val soja = Soja( 2009, 0.6)

        it("dan semillas") {
            soja.daSemilla().shouldBeFalse()

        }
        it("espacio") {
            soja.espacio().shouldBe(0.3)
        }
        it("tolerancia al sol"){
            soja.horasDeSolTolera().shouldBe(8)
        }
    }

    describe("creacion de quinoa") {
        val quinoa = Quinoa1(2010,1.0,3.0)
        val otraQuinoa = Quinoa1(2001,1.0,2.0)

        it("dan semillas") {
            quinoa.daSemilla().shouldBeTrue()
            otraQuinoa.daSemilla().shouldBeTrue()
        }
    }


    //ETAPA 2
    describe("creacion de soja trangenica y peperina"){
        val transgenica = SojaTrangenica(2009,0.6)
        val peperina = Peperina(2021, 1.0)

        it("soja trangenica da semillas"){
            transgenica.daSemilla().shouldBeTrue()
        }
        it("ocupa el doble que menta"){
            peperina.espacio().shouldBe(4.0)
        }
    }
    //ETAPA 3
    describe("parcelas") {
        val soja1 = Soja(2009, 1.1)
        val soja2 = Soja(2009, 1.2)
        val soja3 = Soja(2009, 1.3)
        val soja4 = Soja(2009, 1.4)
        val soja5 = Soja(2009, 1.5)


        val parcela = Parcela(20, 1, 8, mutableListOf (soja1,soja2,soja3,soja4))

        it(" superficie = 20mts ") {
            parcela.superficie().shouldBe(20)
        }
        it(" cant maxima de plantas = 4") {
            parcela.cantidadMaximaTolerada().shouldBe(4)
        }
        it("parcela sin complicaciones") {
        parcela.tieneComplicaciones().shouldBeFalse()
        }

        it("intentar plantar") {
            shouldThrowMessage("Se supero la cantidad de Plantas o le falta Sol"){parcela.plantar(soja5)}
        }
    }
})