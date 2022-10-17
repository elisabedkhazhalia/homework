import kotlin.math.sqrt
import kotlin.math.pow


fun main() {
    val f1 = Fraction(16, 24)
    val f2 = Fraction(2, 3)


    println(f1)
    println(f1.equals(f2))
    println(f1.jami(f2))
    println(f1.gamravleba(f2))
    println(f1.gakofa(f2))
    println(f1.shekveca())
    val place1 = Point(1.0,-1.0)
    val place2 = Point(0.0,0.0)
    val nums = place1.equalNumbers(place2)
    println(nums)
    println(place1.toString())

    val theOtherSide = place1.symmetrical()
    println("$theOtherSide is the symmetric points of place2")

    val length = place2.distance(place1)
    println(length)
}

class Point(private val x: Double, private val y: Double){
    override fun toString(): String {
        return "$x $y"
    }

    fun equalNumbers(other: Point): Boolean {
        return (other.x == this.x) && (other.y == this.y)
    }

    fun symmetrical(): String {
        val negativeX = -x
        val negativeY = -y
        return "$negativeX , $negativeY"
    }

    fun distance(point: Point): Double {
        val horizontal : Double = this.x - point.x
        val vertical : Double = this.y - point.y
        return sqrt(vertical.pow(2.0) + horizontal.pow(2.0))
    }

}

class Fraction(val numerator:Int, val denominator:Int){

    fun jami(fraction: Fraction):Fraction{
        val m = denominator*fraction.denominator
        val k = m/denominator*numerator
        val l = m/fraction.denominator*fraction.numerator
        return Fraction (k+l,m)

    }
    fun gamravleba(fraction: Fraction): Fraction{
        val x = numerator*fraction.numerator
        val z = denominator*fraction.denominator
        return Fraction(x, z)

    }
    fun gakofa(fraction: Fraction):Fraction{
        val r = numerator*fraction.denominator
        val h = denominator*fraction.numerator
        return Fraction(r, h)
    }
    fun shekveca():String {
        var num:Int = numerator
        var den:Int = denominator
        for (i in 2 .. num){
            while (num%i==0 && den%i==0){
                num /= i
                den /= i
            }
        }
        return "$num / $den"
    }

    override fun toString(): String {
        return "$numerator/$denominator"
    }

     fun equals(fr:Fraction): Boolean {
        return this.shekveca() == fr.shekveca()
    }
}