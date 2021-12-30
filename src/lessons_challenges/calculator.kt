fun sum(a:Float, b:Float): Float{
    return a + b
}

fun times(a:Float, b:Float): Float {
    return a*b
}

fun minus(a:Float, b:Float): Float {
    return a - b
}

fun divide(a:Float, b:Float): Float {
    if (b == 0.0F) throw IllegalArgumentException("Division cant be zero.")     
    return a/b
}

fun modulus(a:Float, b:Float): Float {
    return a%b
}

fun powerOf(a: Float, b:Float): Float {
    return Math.pow(a.toDouble(), b.toDouble()).toFloat()
}

fun calculate(a:Float, b:Float, operacao:(Float, Float) -> Float): Float {
	return operacao(a, b)
}

const val SUM = 1
const val SUBTRACTION = 2
const val MULTIPLICATION = 3
const val DIVISION = 4
const val MODULUS = 5
const val POWEROF = 6

fun main(args: Array<String>) {    
    var userChoice = args[0].toInt()
    var a = args[1].toFloat(); var b = args[2].toFloat();
    var operation:(Float, Float) -> Float = ::sum
    
    when (userChoice) {
        SUM -> {operation = ::sum}
        SUBTRACTION -> {operation = ::minus}
        MULTIPLICATION -> {operation = ::times}
        DIVISION -> {operation = ::divide}
        MODULUS -> {operation = ::modulus}
      	POWEROF -> {operation = ::powerOf}
        else -> {System.exit(-1)}   
    }
    
    var res = calculate(a, b, operation)
    println("$res")
}
