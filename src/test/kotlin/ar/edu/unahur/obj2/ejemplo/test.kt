package ar.edu.unahur.obj2.ejemplo
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.doubles.shouldBeBetween
import io.kotest.matchers.shouldBe

class SemillaTest: DescribeSpec( {
    // hay clase Planta que tiene por atributos: año Semilla, altura
    describe(name="Creacion de las plantas"){
        // altura, año
        val menta = Menta( 2021, 1.0)
        val mentita = Menta(2021, 0.3)
        val soja = Soja( 2009, .6)

        describe(name="Los atributos funcionan"){
            it(name = "altura y año") {

                //Verificar altura

                menta.altura.shouldBe(1.0)
                menta.anioSemilla.shouldBe(2021)
            }
        }

        describe(name="Verificar si da semillas") {
            it(name = "menta chica y grande") {
                menta.daSemilla().shouldBeTrue()
                mentita.daSemilla().shouldBeFalse()
                soja.daSemilla().shouldBeFalse()

            }
        }

        it(name = "es fuerte"){
            menta.esFuerte().shouldBeFalse()
            soja.esFuerte().shouldBeFalse()
        }

        it(name = "espacio"){
            menta.espacio().shouldBe(2.0)
            mentita.espacio().shouldBe(1.3)
            soja.espacio().shouldBe(0.3)

        }

        val l = mutableListOf<Planta>()
        l.add(soja)
        l.add(menta)
        l.add(mentita)
        val superficie = Math.ceil(l.sumOf {  p: Planta -> p.espacio() })
        superficie.shouldBe(4)
    }

})